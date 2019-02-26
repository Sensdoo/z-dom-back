package com.sens.app.controller;

import com.sens.app.model.Street;
import com.sens.app.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/street")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StreetAPI {

    @Autowired
    private StreetService streetService;

    @RequestMapping("/{streetId}")
    public ResponseEntity<Street> getStreet(@PathVariable("streetId") Long streetId) {
        Street street = streetService.getStreet(streetId);
        return ResponseEntity.ok(street);
    }

    @RequestMapping("/get-all")
    public ResponseEntity<List<Street>> getAllStreets() {
        List<Street> streets = streetService.getAll();
        return ResponseEntity.ok(streets);
    }
}
