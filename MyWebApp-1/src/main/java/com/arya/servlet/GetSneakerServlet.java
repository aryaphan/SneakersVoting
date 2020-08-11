package com.arya.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arya.dao.SneakerDAO;
import com.arya.model.Sneaker;

//@WebServlet("/redirect")
public class GetSneakerServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	private static String SneakerRecord = "/second.jsp";
	private SneakerDAO dao;
	
	public GetSneakerServlet() {
		super();
		dao = new SneakerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		String redirect = SneakerRecord;
		
		request.setAttribute("sneakers", dao.getAllSneakers());
		
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
//		int imageId = ThreadLocalRandom.current().nextInt(1,15);
//		SneakerDAO dao = new SneakerDAO();
//		
//		try {
//			Sneaker sneaker = dao.get(imageId);
//			System.out.println("hhhh");
//			
//			request.setAttribute("sneaker", sneaker);
//			String page = "/second.jsp";
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
//			requestDispatcher.forward(request, response);
			
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
		}
	}
//}




