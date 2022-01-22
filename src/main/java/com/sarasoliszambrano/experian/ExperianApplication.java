package com.sarasoliszambrano.experian;

import com.sarasoliszambrano.experian.controller.ExperianController;
import com.sarasoliszambrano.experian.repository.ExperianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

@SpringBootApplication
public class ExperianApplication {
	private static final Logger log = LoggerFactory.getLogger(ExperianController.class);

	@Autowired
	private static ExperianRepository experianRepository = new ExperianRepository();

	public static void main(String[] args) {
		SpringApplication.run(ExperianApplication.class, args);
		experianRepository.dataBaseConnection();

	}

}
