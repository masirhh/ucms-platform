package com.masirhh.ucmsplatform.controller;

import com.masirhh.ucmsplatform.domain.ClubType;
import com.masirhh.ucmsplatform.service.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ucms/type")
public class ClubTypeController {
    @Autowired
    ClubTypeService clubTypeService;

    @GetMapping
    public ResponseEntity<List<ClubType>> getClubType(){
        List<ClubType> list = clubTypeService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubType> getClubTypeDetail(@PathVariable(value = "id") Long id){
        ClubType byId = clubTypeService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClubType> insertClubType(ClubType clubType){
        boolean save = clubTypeService.save(clubType);
        return save?new ResponseEntity<>(clubType,HttpStatus.OK):new ResponseEntity<>(clubType,HttpStatus.REQUEST_TIMEOUT);
    }
}
