package com.sarasoliszambrano.experian.repository;

import com.sarasoliszambrano.experian.controller.ExperianController;
import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.model.ExperianModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class ExperianRepository {
    private static final Logger log = LoggerFactory.getLogger(ExperianRepository.class);
    private Connection dbConnection;
    private PreparedStatement prepareStatements;

    public void dataBaseConnection (){
        try {
            log.info("Connecting with mysql");
            String url = "jdbc:mysql://localhost:3306/experian?autoReconnect=true&useSSL=false";
            Properties info = new Properties();
            info.put("user", "root"); info.put("password", "");
            dbConnection = DriverManager.getConnection(url, info);
            log.info("Connection made");
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
            log.error("Error connecting to database");
        }
    }

    public ResultSet getAllValues() throws SQLException {
        String sql = "SELECT * FROM experian.data;";
        prepareStatements = dbConnection.prepareStatement(sql);
        ResultSet result = prepareStatements.executeQuery();

        return result;
    }
}
