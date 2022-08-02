package fpt.aptech.day3uploadimage.repository;

import fpt.aptech.day3uploadimage.model.Images;
import org.springframework.data.repository.CrudRepository;

public interface imageRepository extends CrudRepository<Images, Integer> {
}
