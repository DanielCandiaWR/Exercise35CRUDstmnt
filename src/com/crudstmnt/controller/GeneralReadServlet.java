package com.crudstmnt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crudstmnt.model.Product;
/**
 * Servlet implementation class GeneralReadServlet
 * @author Daniel Candia
 * @version 1.0
 * <p> this is a list of all the products inside my database </p>
 */
@WebServlet("/GeneralReadServlet")
public class GeneralReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @version 1.0
	 * doPost Method used to generate a products list of type MIME text/HTML
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Declare Variables
		String urlServer  = "jdbc:mysql://localhost:3306/store?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String username = "root";
		String password = "root";
		String sqlSentence = "SELECT * FROM PRODUCTS";
		int value = 0;
		//2. Declare Objects
		Connection connection = null;
		Statement stmnt = null;
		ResultSet resultSet = null;
		List<Product> listProducts = null;
		
		
		try {
			//3. Instantiate the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//4. Open the connection
			connection = DriverManager.getConnection(urlServer,username,password);
			//5. Prepare the statement
			//Select executeQuery
			//Alter executeUpdate
			stmnt = connection.createStatement();
			
			//6. Execute the SQLSentence
			resultSet = stmnt.executeQuery(sqlSentence);
			
			listProducts = new ArrayList<>();
			while(resultSet.next()) {
				
				Product product = new Product();
				
				product.setId(resultSet.getInt(1));
				product.setProductName(resultSet.getString(2));
				product.setProductPrice(resultSet.getDouble(3));
				
				listProducts.add(product);
				
				/*response.getWriter().append("<p>");
				response.getWriter().append("idProducto: "+resultSet.getInt(1));
				
				response.getWriter().append("<br/>");
				response.getWriter().append("productName: "+resultSet.getString(2));
				
				response.getWriter().append("<br/>");
				response.getWriter().append("productPrice: "+resultSet.getDouble(3));
				response.getWriter().append("</p>");*/
			
			}
			request.setAttribute("listProducts", listProducts);
			request.getRequestDispatcher("generalRead.jsp").forward(request,response);
		//7. Process the output
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
		//8. Close the connection
			try {
				stmnt.close();
				connection.close();
				resultSet.close();
			}catch(SQLException e){
				e.printStackTrace();
			}

		}
	}

}
