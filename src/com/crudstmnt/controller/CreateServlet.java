package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * 
 * @author Daniel Candia
 * 
 * @since 1.0
 * 
 * 
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doPost Method
	 * 
	 * @param request  This parameter is used to receive the customer's data.
	 * @param response This parameter is used to send data to the customers.
	 * 
	 * @return The response object with the answer
	 */
	//This method catcht post request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json charset='utf-8'");
		PrintWriter output = response.getWriter();
		String productName = request.getParameter("txtProductName");
		double productPrice = Double.parseDouble(request.getParameter("txtProductPrice"));
		
		//1. Declare Variables
		String urlServer = "jdbc:mysql://localhost:3306/store?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		int rowsAffected = 0;
		//2. Declare Objects
		//Connection connection = null;
		//Statement stmnt = null;
		//ResultSet rs = null;
		
		//3. Instantiate the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection connection = DriverManager.getConnection(urlServer,userName,password);
			Statement stmnt = connection.createStatement();
			rowsAffected = stmnt.executeUpdate("INSERT INTO PRODUCTS(product_name,product_price) VALUES('"+productName+"',"+productPrice+")");  
			if(rowsAffected!=0)
				output.append("Register add Successfully");
			else
				output.append("Fail, something was wrong");
			stmnt.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//4. Open the connection
		//5. Execute the sql sentence
		//6. Process the data
		//7. Close the object connections
	}

}
