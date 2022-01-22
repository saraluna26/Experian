package com.sarasoliszambrano.experian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

@SpringBootApplication
public class ExperianApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExperianApplication.class, args);
		try {
			System.out.println("Connecting with mysql");

			String url = "jdbc:mysql://localhost:3306/experian?autoReconnect=true&useSSL=false";
			Properties info = new Properties();
			info.put("user", "root"); info.put("password", "");
			Connection dbConnection = DriverManager.getConnection(url, info);

			//Read more: https://javarevisited.blogspot.com/2016/09/javasqlsqlexception-no-suitable-driver-mysql-jdbc-localhost.html#ixzz7IXvJiekY


			/*Connection conn = null;
			Statement statement = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:://localhost:3306/experian", "root", "");*/
			System.out.println("Connection made");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			System.out.println("Error connecting to the database");
		}
	}

}
