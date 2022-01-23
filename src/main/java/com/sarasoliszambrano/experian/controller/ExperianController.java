package com.sarasoliszambrano.experian.controller;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.service.ExperianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("/experian")
public class ExperianController {
    private static final Logger log = LoggerFactory.getLogger(ExperianController.class);

    @Autowired
    ExperianService experianService;

    @GetMapping(path = "/getAll", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperianDto>> getAll() throws Exception {
        log.debug(" ------ In Get All Controller ------- ");
        List<ExperianDto> responseList = experianService.getAllValues();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping(path="/updateRecord", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExperianDto> updateRecord(@RequestBody ExperianDto experianDto) throws Exception {
        log.debug(" ------ In Update Record Controller ------- ");
        experianService.updateRecord(experianDto);
        return new ResponseEntity<>(HttpStatus.OK);
        // para cuando tenemos la insercion -- seguir buscando el error
    }
}
