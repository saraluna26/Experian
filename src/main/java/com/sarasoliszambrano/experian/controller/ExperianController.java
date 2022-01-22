package com.sarasoliszambrano.experian.controller;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.service.ExperianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/experian")
public class ExperianController {
    private static final Logger log = LoggerFactory.getLogger(ExperianController.class);

    @Autowired
    ExperianService experianService;

    @GetMapping(path = "/getAll", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperianDto>> getAll() throws Exception {
        log.debug(" ------ In Get Company Name Controller ------- ");
        List<ExperianDto> responseListTest = experianService.getAllValues();
        return new ResponseEntity<>(responseListTest, HttpStatus.OK);

    }
}
