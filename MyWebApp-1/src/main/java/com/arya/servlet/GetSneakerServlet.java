package com.arya.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arya.dao.SneakerDAO;
import com.arya.model.Sneaker;

@WebServlet("/secondPage")
public class GetSneakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GetSneakerServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId = (int) (Math.random() * 15);
		SneakerDAO dao = new SneakerDAO();
		
		try {
			Sneaker sneaker = dao.get(imageId);
			
			request.setAttribute("sneaker", sneaker);
			String page = "/second.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

}



