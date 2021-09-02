package com.arya.application;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arya.dao.SneakerDAO;
import com.arya.model.Sneaker;


import java.util.List;


/*
 * Handles requests and returns appropriate JSP pages
 * */
@Controller
public class HomeController {
	
	
	@Autowired
	private SneakerDAO dao;
	
	
	
	/*
	 * Returns showRanks.jsp page
	 * */
	@RequestMapping(value="/showRanks", method = RequestMethod.GET)
	public String rankingPage() {
		System.out.println("calling showRank page");
		return "showRanks";
	}
	
	/*
	 * Returns about.jsp page
	 * */
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String aboutPage() {
		System.out.println("calling about page");
		return "about";
	}
	
	/*
	 * Returns upload.jsp page
	 * */
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String uploadPage() {
		System.out.println("calling upload page");
		return "upload";
	}
	
	/*
	 * Sends the list of all sneakers in the database to vote.jsp page to handle and returns vote.jsp page
	 * */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView listSneaker(ModelAndView model) throws IOException {
		System.out.println("calling voting page");
		List<Sneaker> sneakerList = dao.getAllSneakers();
		model.addObject("sneakerList", sneakerList);
		model.setViewName("vote");
		return model;
	}
	
	/*
	 * Displays an image that matches <code>id</code> in the database
	 * @param id: identifier of the image to be displayed
	 * */
	@RequestMapping(value="/getSneakerImage/{id}")
	public void getSneakerImage(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpg");
		Blob image = dao.getPhotoById(id);
		
		byte[] bytes = image.getBytes(1, (int) image.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
}

