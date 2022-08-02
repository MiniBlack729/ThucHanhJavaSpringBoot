package com.example.day3_showroom.repository;

import com.example.day3_showroom.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer,Long> {
}
