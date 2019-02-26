package com.sens.app.service;

import com.sens.app.model.Address;
import com.sens.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllByStreetId(Long streetId) {
        return addressRepository.findByStreetId(streetId);
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long addressId) {
        return addressRepository.getOne(addressId);
    }
}
