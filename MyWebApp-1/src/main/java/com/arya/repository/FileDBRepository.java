package com.arya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arya.model.*;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
