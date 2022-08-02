package com.example.day3_showroom.service;

import com.example.day3_showroom.model.Manufacturer;
import com.example.day3_showroom.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManuService {
    @Autowired
    private ManufacturerRepository manuRepo;

    public List<Manufacturer> showAll(){
        return (List<Manufacturer>) manuRepo.findAll();
    }
}
