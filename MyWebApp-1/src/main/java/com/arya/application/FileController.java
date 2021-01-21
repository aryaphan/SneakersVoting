package com.arya.application;

import com.arya.message.*;
import com.arya.model.FileDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arya.service.FileStorageService;




@RestController
//@CrossOrigin("http://localhost:8080")
public class FileController {
	
	@Autowired		//inject implementation of FileStorageService bean to local variable
	private FileStorageService storageService;
	
	@PostMapping("/uploadFile")
	public ResponseFile uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println("upload");
		FileDB filename = storageService.store(file);
		
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(filename.getName())
				.toUriString();
		return new ResponseFile(filename.getName(), fileDownloadUri, file.getContentType(), file.getSize());
		//String message = "";
		
		/*
		 * try { storageService.store(file); message = "Uploaded files successfully: " +
		 * file.getOriginalFilename(); return
		 * ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message)); }
		 * catch (IOException e) { message = "Could not upload the file: " +
		 * file.getOriginalFilename(); return
		 * ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
		 * ResponseMessage(message)); }
		 */
	}
	
	@PostMapping("/uploadMultipleFiles")
	public List<ResponseFile> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
		System.out.println("upload multiple");
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles(){
		List<ResponseFile> files = storageService.getAllFiles().map(file -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.path(file.getId())
					.toUriString();
			
			return new ResponseFile(file.getName(), fileDownloadUri, file.getType(), file.getData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename, HttpServletRequest request){
		FileDB fileDB = storageService.getFile(filename);
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(fileDB.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(new ByteArrayResource(fileDB.getData()));
	}
}
