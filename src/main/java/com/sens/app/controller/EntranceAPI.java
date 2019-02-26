package com.sens.app.controller;

import com.sens.app.dto.EntranceDto;
import com.sens.app.message.response.ResponseMessage;
import com.sens.app.model.Address;
import com.sens.app.model.Entrance;
import com.sens.app.service.AddressService;
import com.sens.app.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/entrance")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EntranceAPI {

    @Autowired
    private EntranceService entranceService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<?> addEntrance(@Valid @RequestBody EntranceDto dto) {

        if (entranceService.existsByEntranceNumberAndAddressId(
                dto.getEntranceNumber(), dto.getAddressId())) {
            return new ResponseEntity<>(new ResponseMessage("Ошибка -> Такая парадная уже существует"),
                HttpStatus.BAD_REQUEST);
        }

        Address address = addressService.getAddressById(dto.getAddressId());

        Entrance entrance = new Entrance(
                dto.getAccess(),
                dto.getLastUpdate(),
                dto.getEditor(),
                dto.getEntranceNumber(),
                dto.getDescriptionInterzet(),
                dto.getDescriptionDomru(),
                address
        );

        Entrance addedEntrance = entranceService.saveEntrance(entrance);
        dto.setId(addedEntrance.getId());

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<EntranceDto> editEntrance(@Valid @RequestBody EntranceDto dto) {
        Address address = addressService.getAddressById(dto.getAddressId());

        Entrance entrance = new Entrance(
                dto.getAccess(),
                dto.getLastUpdate(),
                dto.getEditor(),
                dto.getEntranceNumber(),
                dto.getDescriptionInterzet(),
                dto.getDescriptionDomru(),
                address
        );
        entrance.setId(dto.getId());

        entranceService.saveEntrance(entrance);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntrance(@PathVariable("id") Long id) {
        entranceService.deleteEntrance(id);
        return ResponseEntity.ok(new ResponseMessage("Парадная успешно удалена!"));
    }

    @RequestMapping("/{addressId}")
    public ResponseEntity<List<Entrance>> getAllEntrancesByAddressId(@PathVariable("addressId") Long addressId) {
        List<Entrance> entrances = entranceService.getAllByAddressId(addressId);
        return ResponseEntity.ok(entrances);
    }

    @RequestMapping("/get-all")
    public ResponseEntity<List<Entrance>> getAll() {
        List<Entrance> entrances = entranceService.getAll();
        return ResponseEntity.ok(entrances);
    }
}
