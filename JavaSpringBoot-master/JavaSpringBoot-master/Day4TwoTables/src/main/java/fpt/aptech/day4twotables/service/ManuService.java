package fpt.aptech.day4twotables.service;

import fpt.aptech.day4twotables.model.Manufacturer;
import fpt.aptech.day4twotables.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManuService {
    @Autowired
    private ManufacturerRepository manuRepo;

    //show all manufacturer
    public List<Manufacturer> showAll(){ return (List<Manufacturer>) manuRepo.findAll(); }
}
