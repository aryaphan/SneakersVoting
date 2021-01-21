package com.arya.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.arya.model.FileDB;
import com.arya.repository.FileDBRepository;


@Service
public class FileStorageService {
	
	@Autowired
	private FileDBRepository fileDBRepository;
	
	/*
	 * Receives MultipartFile object, transform to FileDB object and save to database
	 * */
	public FileDB store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDB = new FileDB(filename, file.getContentType(), file.getBytes());
		return fileDBRepository.save(fileDB);
	}
	
	/*
	 * returns a FileDB by a given id
	 * */
	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}
	
	/*
	 * returns all stored files as a stream of FileDB objects
	 * */
	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
}
