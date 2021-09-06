package com.arya.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.arya.dao.SneakerDAO;
import com.arya.model.Sneaker;
import com.arya.rating.RatingHandler;

/*
 * Handles requests and responses of vote.jsp and nextRound.jsp. Redirects to appropriate jsp pages 
 * */
@WebServlet("/ContinueVoting")
public class ContinueVoting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//counter controls how many times nextRound.jsp has been called
	int counter = 0;
	
	@Autowired
	private SneakerDAO dao;
	
	public ContinueVoting() {
		super();
		System.out.println("servlet");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet activated");
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		
		
		String img1 = request.getParameter("img1.x");
		String img2 = request.getParameter("img2.x");
		
		List<Sneaker> sneakerList = dao.getAllSneakers();
		
		if(img1 != null) {
			//sneaker A wins
			System.out.println("sneaker A wins. calculating scores");
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), true);
		}
		else if (img2 != null) {
			//sneaker B wins
			System.out.println("sneaker B wins. calculating scores");
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), false);
		}
		
		//generate random id for next page
		int size = sneakerList.size();
		int num1 = ThreadLocalRandom.current().nextInt(0,size);
		int num2 = ThreadLocalRandom.current().nextInt(0,size);
		
		//make sure num1 != num2
		while (num2 == num1) {
			num2 = ThreadLocalRandom.current().nextInt(0,size);
		}
		
		//sends requests to the next page
		request.setAttribute("id1", num1);
		request.setAttribute("id2", num2);
		request.setAttribute("sneakerList", sneakerList);
		counter++;
		request.setAttribute("counter", counter);
		
		//if counter < 10, continue voting
		if (counter < 10) {
//			getServletConfig().getServletContext().getRequestDispatcher("/pages/nextRound.jsp").forward(request, response);
			getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/nextRound.jsp").forward(request, response);
		}
		
		//otherwise, show rankings
		else {
			//reset counter
			counter = 0;
//			getServletConfig().getServletContext().getRequestDispatcher("/pages/showRanks.jsp").forward(request, response);
			getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/showRanks.jsp").forward(request, response);
		}
		
		
	}
	
}