package com.sarasoliszambrano.experian.repository;

import com.sarasoliszambrano.experian.controller.ExperianController;
import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.model.ExperianModel;
import org.json.JSONObject;
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
    private ResultSet allValuesResult;

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
        allValuesResult = prepareStatements.executeQuery();

        return allValuesResult;
    }

    public void updateRecord(ExperianModel model) throws SQLException {
        allValuesResult = getAllValues();
        Boolean exist = false;
        Integer currentId = null;
        while (allValuesResult.next()) {
            currentId = allValuesResult.getInt("msg_id");
            if (model.getId() == currentId) {
                exist = true;
            }
        }
        if (!exist){
            log.info("The id does not exist -- inserting new row...");
            insertValue(model);
        } else {
            log.info("The id exist -- updating the row...");
            updateValue(model);
        }
    }

    public void insertValue (ExperianModel model) throws SQLException {
        log.info(" ---- In inserting new value ---- ");
        /*String sql = "INSERT INTO experian.data(msg_id, company_name, registration_date, score, directors_count,last_updated) VALUES (?, ?, ?, ?, ?, ?)";
        //try{
            prepareStatements =  dbConnection.prepareStatement(sql);
            allValuesResult = getAllValues();
            Integer newId = null;

            if(allValuesResult.last()){
                newId = allValuesResult.getInt("msg_id") + 1;
                log.info("last id  ---- " + newId);
            }
            log.info("Id valuee  ---- " + newId);
            prepareStatements.setInt(1, newId);
            prepareStatements.setString(2, model.getCompanyName());
            prepareStatements.setDate(3, model.getRegistrationDate());
            prepareStatements.setFloat(4, model.getScore());
            prepareStatements.setInt(5, model.getDirectorsCount());
            prepareStatements.setDate(6, model.getLastUpdated());

            prepareStatements.executeUpdate();
        //    log.info("New value added");
       // }catch(SQLException e) {
           // log.error("Error adding or updating a new row");
        //}

     //   INSERT INTO `experian`.`data` (`msg_id`, `company_name`, `registration_date`, `score`, `directors_count`, `last_updated`)
        //VALUES ('2', 'Experian2', '2022-01-19 12:35:29', '6.2', '5', '2022-01-20 12:35:29');*/

    }

    public void updateValue (ExperianModel model) throws SQLException {
        log.info(" ---- In updating the value ---- ");

        String sql = "UPDATE experian.data " +
                "SET company_name = ? " +
                "WHERE msg_id = ?";

        log.info(" ---- Values model  ---- ");
        log.info(model.getCompanyName() + model.getId());

        prepareStatements =  dbConnection.prepareStatement(sql);
        prepareStatements.setString(1, model.getCompanyName());
        prepareStatements.setInt(2, model.getId());
        prepareStatements.executeUpdate();

        /*prepareStatements.setInt(1, newId);
        prepareStatements.setString(2, model.getCompanyName());
        prepareStatements.setDate(3, model.getRegistrationDate());
        prepareStatements.setFloat(4, model.getScore());
        prepareStatements.setInt(5, model.getDirectorsCount());
        prepareStatements.setDate(6, model.getLastUpdated()); */
    }
}
