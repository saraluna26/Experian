package com.sarasoliszambrano.experian.repository;

import com.sarasoliszambrano.experian.model.ExperianModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
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
        Boolean exist = false;
        Integer currentId;

        allValuesResult = getAllValues();
        while (allValuesResult.next()) {
            currentId = allValuesResult.getInt("msg_id");
            if (model.getId() == currentId) {
                exist = true;
            }
        }
        if (!exist){
            log.info("The id does not exist -- Inserting new row...");
            insertValue(model);
        } else {
            log.info("The id exist -- Updating the value...");
            updateValue(model);
        }
    }

    public void insertValue (ExperianModel model) {
        log.debug(" ... in adding new value ... ");
        String sql = "INSERT INTO experian.data(msg_id, company_name, registration_date, score, directors_count,last_updated) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            prepareStatements = dbConnection.prepareStatement(sql);

            prepareStatements.setInt(1, model.getId());
            prepareStatements.setString(2, model.getCompanyName());
            prepareStatements.setDate(3, model.getRegistrationDate());
            prepareStatements.setFloat(4, model.getScore());
            prepareStatements.setInt(5, model.getDirectorsCount());
            prepareStatements.setDate(6, model.getLastUpdated());

            prepareStatements.executeUpdate();
            log.info(" ... new value added! ");
        }catch (SQLException e){
            log.error("Error adding a new row", e);
        }

    }

    public void updateValue (ExperianModel model) throws SQLException {
        log.debug(" ... in updating the value ... ");
        try {
            String sql = "UPDATE experian.data SET company_name = ? WHERE msg_id = ?";
            prepareStatements =  dbConnection.prepareStatement(sql);
            prepareStatements.setString(1, model.getCompanyName());
            prepareStatements.setInt(2, model.getId());
            prepareStatements.executeUpdate();

            sql = "UPDATE experian.data SET registration_date = ? WHERE msg_id = ?";
            prepareStatements =  dbConnection.prepareStatement(sql);
            prepareStatements.setDate(1, model.getRegistrationDate());
            prepareStatements.setInt(2, model.getId());
            prepareStatements.executeUpdate();

            sql = "UPDATE experian.data SET score = ? WHERE msg_id = ?";
            prepareStatements =  dbConnection.prepareStatement(sql);
            prepareStatements.setFloat(1, model.getScore());
            prepareStatements.setInt(2, model.getId());
            prepareStatements.executeUpdate();

            sql = "UPDATE experian.data SET last_updated = ? WHERE msg_id = ?";
            prepareStatements =  dbConnection.prepareStatement(sql);
            prepareStatements.setDate(1, model.getLastUpdated());
            prepareStatements.setInt(2, model.getId());
            prepareStatements.executeUpdate();


            sql = "UPDATE experian.data SET directors_count = ? WHERE msg_id = ?";
            prepareStatements =  dbConnection.prepareStatement(sql);
            prepareStatements.setInt(1, model.getDirectorsCount());
            prepareStatements.setInt(2, model.getId());
            prepareStatements.executeUpdate();

            log.info(" ... value updated! ");
        } catch (SQLException e){
            log.error("Error updating the row", e);
        }
    }
}
