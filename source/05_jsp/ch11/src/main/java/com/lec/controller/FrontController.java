package com.lec.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 무슨 요청이 들어왔는지 판별 (insert.do, select.do, update.do, delete.do ?)
		String uri = request.getRequestURI(); // "/ch11/insert.do"
		String conPath = request.getContextPath(); // "/ch11"
		String command = uri.substring(conPath.length()); //"/insert.do"
		System.out.println("들어온 요청 : " + command);
		if(command.equals("/insert.do")) {
			// insert.do 요청이 들어오면 할 일
			System.out.println("insert 할 일 후, view 페이지로");
		}else if(command.equals("/select.do")) {
			// select.do 요청이 들어오면 할 일
			System.out.println("select 할 일 후, view 페이지로");
		}else if(command.equals("/update.do")) {
			// update.do 요청이 들어오면 할 일
			System.out.println("update 할 일 후, view 페이지로");
		}else if(command.equals("/delete.do")) {
			// delete.do 요청이 들어오면 할 일
			System.out.println("delete 할 일 후, view 페이지로");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}











