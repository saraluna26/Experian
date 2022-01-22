package com.sarasoliszambrano.experian.controller;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.model.ExperianModel;
import com.sarasoliszambrano.experian.service.ExperianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
        log.debug(" ------ In Get All Controller ------- ");
        List<ExperianDto> responseList = experianService.getAllValues();
        return new ResponseEntity<>(responseList, HttpStatus.OK);

    }

    @PutMapping(path = "/updateRecord/{msg_id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ExperianDto> updateRecord(@PathVariable(value = "msg_id") Long userId/*, @RequestBody ExperianDto experianDto*/) throws Exception {
        log.debug(" ------ In Update Record Controller ------- ");
        //ExperianDto dto = new ExperianDto(7, "Sara", new Date(2L), 3.3F, 3, new Date(3L));
        ExperianModel model= new ExperianModel(3, "TestUpdate", new Date(2L), 3.3F, 3, new Date(3L));
        // if (id exist) -- update
        // else -- add new;
        experianService.updateRecord(model);
        return new ResponseEntity<ExperianDto>(HttpStatus.OK);
        // anadir information necesaria para construir el dto ? desde el json y luego en el servicio convertirlo a modelo
        // para cuando tenemos la insercion -- seguir buscando el error
    }
}
