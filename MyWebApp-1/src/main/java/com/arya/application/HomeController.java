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


@Controller
public class HomeController {
	
	
	@Autowired
	private SneakerDAO dao;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		System.out.println("calling home page");
		return "home";
	}
	
	@RequestMapping(value="/redirect", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:secondPage";
	}
	
	@RequestMapping(value="/vote", method = RequestMethod.GET)
//	public String secondPage() {
//		return "second" ;
//	}
	public ModelAndView listSneaker(ModelAndView model) throws IOException {
		System.out.println("calling second page");
		List<Sneaker> sneakerList = dao.getAllSneakers();
		model.addObject("sneakerList", sneakerList);
		model.setViewName("vote");
		return model;
	}
	
	@RequestMapping(value="/getSneakerImage/{id}")
	public void getSneakerImage(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpg");
		Blob image = dao.getPhotoById(id);
		
		byte[] bytes = image.getBytes(1, (int) image.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}

