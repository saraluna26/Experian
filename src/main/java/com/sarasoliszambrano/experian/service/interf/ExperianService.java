package com.sarasoliszambrano.experian.service.interf;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/*
 * Service interface for communicating with the database and converting the data type (Dto and Entity)
 */
@Service
public interface ExperianService {

    /*
     * Method to get all the rows saved in out table data in the database.
     * Convert entity from database (model) to a Dto to comunicate with the rest of our app.
     */
    List<ExperianDto> getAllValues () throws SQLException, JSONException;

    /*
     * Update a value in the database, if the value does not exits, it will be added.
     */
    void updateRecord(ExperianDto dto) throws SQLException, JSONException;
}
