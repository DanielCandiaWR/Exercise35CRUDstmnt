package com.crudstmnt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crudstmnt.model.Product;

public class DataBaseManager {
	private Connection connection;
	private static Statement stmnt = null;
	private static ResultSet resultSet = null;
	
	public DataBaseManager() {
		
	}
	
	public DataBaseManager(Connection connection) {
		this.connection = connection;
	}
	
	public void createProduct(Product product) {
		String query = "INSERT INTO PRODUCTS(PRODUCT_NAME,PRODUCT_PRICE) VALUES("+product.toString()+");";
		executeSQLStatement(query);
	}
	
	public List<Product> readProduct(){
		String query = "SELECT * FROM PRODUCTS";
		//Statement stmnt = null;
		//ResultSet resultSet = null;
		List<Product> listProducts = null;
		try {
			stmnt = connection.createStatement();
			resultSet = stmnt.executeQuery(query);
			listProducts = new ArrayList<>();
			while(resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt(1));
				product.setProductName(resultSet.getString(2));
				product.setProductPrice(resultSet.getDouble(3));
				
				listProducts.add(product);
			}
		}catch(SQLException e) {
			
		}
		return listProducts;
	}
	
	public Product readSingle(int id) {
		String query = "SELECT * FROM PRODUCTS WHERE ID="+id;
		Product product = new Product();
		try {
			stmnt = connection.createStatement();
			resultSet = stmnt.executeQuery(query);
				
			product.setId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setProductPrice(resultSet.getDouble(3));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	private void executeSQLStatement(String query) {
		//Statement stmnt = null;
		try {
			stmnt = connection.createStatement();
			stmnt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
