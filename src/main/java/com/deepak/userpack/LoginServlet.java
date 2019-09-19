package com.deepak.userpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final String CONTENT_TYPE="text/html; charset=UTF-8";
	private static final long serialVersionUID = 1L;
	 private static String name,password,radioo,person;
	 private static Connection con;
	public static void createConnection(){
        try {
        	System.out.println("hi");
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/shopdb","root","");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in forName()...\n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error in getConnection()...\n");
			e.printStackTrace();
		}
        
    }
	
    public LoginServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out= response.getWriter();
		out.print("inside post ");
		out.println("<html>");
		out.println("<body>");
		name= request.getParameter("Personname");
		password= request.getParameter("Personpass");
					
		int uid= checkpas(name, password);
		HttpSession session= request.getSession();
		session.setAttribute("uid", uid);
		
		System.out.println("Inside do post "+name);
		System.out.println("outside "+password);
		
		if(uid>0){	
		System.out.println("yes it worked");
		System.out.println(request.getRequestURI());
		System.out.println("path info"+request.getPathInfo());
	
			response.setContentType("text/html");
				
			    out.print("in validate page");
				//session.setAttribute("name",name);
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/Displayproducts");
			requestDispatcher.forward(request, response);
		}
		
		
		else{
			
			out.print("inside else part");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.html");
			requestDispatcher.forward(request, response);
		}
		
	}
	public int checkpas(String user, String password) {
		PreparedStatement statement=null;
		System.out.println("inside check password");
		int cnt=0,id=0;
		try{
			System.out.println("hi");
			 Class.forName("com.mysql.jdbc.Driver");
			
		        con= DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/shopdb","root","");
			String sql= "SELECT uid FROM user_credentials WHERE uname = ? and password = ?";
		 statement =con.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet rSet=statement.executeQuery();
		while(rSet.next()){
			id=rSet.getInt(1);
			++cnt;
		
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
