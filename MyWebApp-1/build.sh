show_help() {
  printf "\nUsage: $0 COMMAND [--OPTION]\n\n"
  printf "Commands:\n"
  printf "  run                   run the code (useful for local development)\n"
  printf "  build [--push][--deploy]  build the docker image\n"
  printf "    --push                  push the docker image to the AWS registry.\n"
  printf "    --deploy                deploys the latest image to the AWS Cluster.\n"
}

SERVICE_NAME="sneakers-voting"
VERSION_SHORT="0.1.0"
AWS_ECR="$ACCOUNT_ID.dkr.ecr.us-west-1.amazonaws.com"

REGION=us-west-1

ECS_CLUSTER="sneakers-voting"
ECS_SERVICE_NAME="${ECS_CLUSTER}"
ECS_TASK_DEF="sneakers-voting"

DOCKER_TAGS="${DOCKER_TAGS:-latest}"
TAG="${TAG:-latest}"

aws_login() {
   aws ecr get-login-password | docker login \
      --username AWS \
      --password-stdin ${AWS_ECR}
}

build() {
  mvn clean package
  docker_tag_args=""
  IFS=',' read -ra TAGS_ARRAY <<< "$DOCKER_TAGS"
  for tag in "${TAGS_ARRAY[@]}"; do
    docker_tag_args="$docker_tag_args -t ${AWS_ECR}/${SERVICE_NAME}:${tag}"
  done

  docker build \
    -f ./Dockerfile \
    $docker_tag_args \
    .
}

start_run() {
  mvn spring-boot:run
}

push_image() {
  aws_login
  docker_tag_args=""
  IFS=',' read -ra TAGS_ARRAY <<< "$DOCKER_TAGS"
  for tag in "${TAGS_ARRAY[@]}"; do
    echo "pushing image to aws: "${AWS_ECR}/${SERVICE_NAME}:${tag}
    docker push ${AWS_ECR}/${SERVICE_NAME}:${tag}
    #docker rmi -f ${AWS_ECR}/${SERVICE_NAME}:${tag}
  done
}

#deploy_image() {
#    printf "Deploying the image to the ECS cluster ...\n"
#    REVISION=`aws ecs describe-task-definition --task-definition ${ECS_TASK_DEF} --region ${REGION} | jq .taskDefinition.revision`
#    DESIRED_COUNT=`aws ecs describe-services --services ${ECS_SERVICE_NAME} --cluster ${ECS_CLUSTER} --region ${REGION} | jq .services[].desiredCount`
#    aws ecs update-service --cluster ${ECS_CLUSTER} --region ${REGION} --service ${ECS_SERVICE_NAME} --task-definition ${ECS_TASK_DEF}:${REVISION} --desired-count ${DESIRED_COUNT} --force-new-deployment >/dev/null
#}


if [ "$#" -lt 1 ]; then
  show_help
  exit 1
fi

case "$1" in
  run)
    start_run
  ;;
  build)
    shift
    case "$1" in
      "")
        build
        ;;
      --push)
        build
        if [ "$?" -eq 0 ]; then
          push_image
        else
          printf "Build failed. Did not push image.\n"
        fi
        ;;
      --deploy)
        build
        if [ "$?" -eq 0 ]; then
          push_image
          if [ "$?" -eq 0 ]; then
            deploy_image
          else
            printf "Push image failed. Did not deploy image.\n"
          fi
        else
          printf "Build failed. Did not push image.\n"
        fi
        ;;
      *)
        printf "\nUnknown option to build command: $1\n\n"
        show_help
        ;;
    esac
    ;;
  *)
    printf "\nUnknown option for the command: $1\n"
    show_help
    exit 2
  ;;
esac

exit 0