package com.sens.app.controller;

import com.sens.app.model.Address;
import com.sens.app.repository.AddressRepository;
import com.sens.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AddressAPI {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{streetId}")
    public ResponseEntity<?> getAddressesByStreetId(@PathVariable("streetId") Long streetId) {
        List<Address> addresses = addressService.getAllByStreetId(streetId);
        return ResponseEntity.ok(addresses);
    }

    @RequestMapping("/get-all")
    public ResponseEntity<?> getAllAddresses() {
        List<Address> addresses = addressService.getAll();
        return ResponseEntity.ok(addresses);
    }
}
