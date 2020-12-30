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

@WebServlet("/ContinueVoting")
public class ContinueVoting extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			System.out.println("calculating sneaker A score");
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), true);
		}
		else if (img2 != null) {
			//sneaker B wins
			System.out.println("calculating sneaker B score");
			RatingHandler.getNewRating(Integer.parseInt(id1), Integer.parseInt(id2), false);
		}
		
		//generate random id for next page
		int size = sneakerList.size();
		int num1 = ThreadLocalRandom.current().nextInt(0,size);
		int num2 = ThreadLocalRandom.current().nextInt(0,size);
		
		while (num2 == num1) {
			num2 = ThreadLocalRandom.current().nextInt(0,size);
		}
		
		request.setAttribute("id1", num1);
		request.setAttribute("id2", num2);
		request.setAttribute("sneakerList", sneakerList);
		counter++;
		request.setAttribute("counter", counter);
		
		if (counter < 10) {
			getServletConfig().getServletContext().getRequestDispatcher("/pages/nextRound.jsp").forward(request, response);
		}
		else {
			/*
			 * ArrayList<Sneaker> sneakerRanks = RatingHandler.getRanking();
			 * request.setAttribute("sneakerRanks", sneakerRanks);
			 */
			getServletConfig().getServletContext().getRequestDispatcher("/pages/showRanks.jsp").forward(request, response);
		}
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("nextRound.jsp");
//		requestDispatcher.forward(request, response);
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/nextRound.jsp");
		//dispatcher.forward(request, response);
	}
	
}