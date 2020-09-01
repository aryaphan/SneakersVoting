package com.arya.servlet;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arya.rating.RatingHandler;

@WebServlet(value="/ContinueVoting")
public class ContinueVoting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ContinueVoting() {
		super();
		System.out.println("servlet");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet activated");
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		
		
		String img1 = request.getParameter("img1");
		String img2= request.getParameter("img2");
		
		if(img1 != null) {
			//sneaker A wins
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), true);
		}
		else if (img2 != null) {
			//sneaker B wins
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), false);
		}
		
		//generate random id for next page
		int num1 = ThreadLocalRandom.current().nextInt(0,14);
		int num2 = ThreadLocalRandom.current().nextInt(0,14);
		
		while (num2 == num1) {
			num2 = ThreadLocalRandom.current().nextInt(0,14);
		}
		
		request.setAttribute("id1", num1);
		request.setAttribute("id2", num2);
		
		getServletConfig().getServletContext().getRequestDispatcher("/nextRound.jsp").forward(request, response);
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("nextRound.jsp");
//		requestDispatcher.forward(request, response);
		
	}
	
}
