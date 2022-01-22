package com.sarasoliszambrano.experian.controller;

import com.sarasoliszambrano.experian.service.ExperianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/experian")
public class ExperianController {
    private static final Logger log = LoggerFactory.getLogger(ExperianController.class);

    @Autowired
    ExperianService experianService;

    @GetMapping(path = "/company_name", produces = APPLICATION_JSON_VALUE)
    public void getCompanyName() throws Exception {
        log.info(" ------ In Get Company Name Controller ------- ");


    }
}
