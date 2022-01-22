package com.sarasoliszambrano.experian;

import com.sarasoliszambrano.experian.controller.ExperianController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

@SpringBootApplication
public class ExperianApplication {
	private static final Logger log = LoggerFactory.getLogger(ExperianController.class);

	private static void main(String[] args) {
		//SpringApplication.run(ExperianApplication.class, args);
		try {
			log.info("Connecting with mysql");
			String url = "jdbc:mysql://localhost:3306/experian?autoReconnect=true&useSSL=false";
			Properties info = new Properties();
			info.put("user", "root"); info.put("password", "");
			Connection dbConnection = DriverManager.getConnection(url, info);
			log.info("Connection made");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			log.error("Error connecting to database");
		}
	}

}
