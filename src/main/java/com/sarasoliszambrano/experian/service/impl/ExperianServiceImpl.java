package com.sarasoliszambrano.experian.service.impl;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.model.ExperianModel;
import com.sarasoliszambrano.experian.repository.ExperianRepository;
import com.sarasoliszambrano.experian.service.ExperianService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExperianServiceImpl implements ExperianService {
    private static final Logger log = LoggerFactory.getLogger(ExperianServiceImpl.class);

    @Autowired
    ExperianRepository experianRepository;

    @Override
    public List<ExperianDto> getAllValues() throws SQLException, JSONException {
        log.debug(" ------ In GetAllValues Method in ServiceImpl ------- ");

        experianRepository.dataBaseConnection();
        ResultSet allValuesModelrs = experianRepository.getAllValues();
        ArrayList<ExperianModel> allValuesModelList = new ArrayList<ExperianModel>();
        while(allValuesModelrs.next()) {
            allValuesModelList.add(new ExperianModel(allValuesModelrs.getString("company_name"),
                    allValuesModelrs.getDate("registration_date"),
                    allValuesModelrs.getFloat("score"),
                    allValuesModelrs.getInt("directors_count"),
                    allValuesModelrs.getDate("last_updated")));
        }
        return allValuesModelList.stream().map(ExperianDto::from).collect(Collectors.toList());
    }

    @Override
    public List<ExperianDto> addNewValue() throws SQLException, JSONException {
        return null;
    }

    @Override
    public List<ExperianDto> updateValue() throws SQLException, JSONException {
        return null;
    }
}
