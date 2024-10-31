package com.lec.ex.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lec.ex.service.InfoService;
import com.lec.ex.service.ListService;
import com.lec.ex.service.Service;
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
		String viewPage = null;
		if(command.equals("/list.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "person/list.jsp";
		}else if(command.equals("/info.do")) {
			service = new InfoService();
			service.execute(request, response);
			viewPage = "person/info.jsp";
		}
			
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
		String viewPage = null;
		if(command.equals("/list.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "person/list.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
