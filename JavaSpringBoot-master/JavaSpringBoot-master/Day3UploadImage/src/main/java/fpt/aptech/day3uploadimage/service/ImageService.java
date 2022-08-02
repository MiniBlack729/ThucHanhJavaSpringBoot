package fpt.aptech.day3uploadimage.service;

import fpt.aptech.day3uploadimage.model.Images;
import fpt.aptech.day3uploadimage.repository.imageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private imageRepository repo;

    //show all
    public List<Images> showAll(){ return (List<Images>) repo.findAll(); }

    //hàm insert or update
    public void InsertOrUpdate(Images image){
        repo.save(image);
    }

    //search by id
    public Images getImageById(int id){ return repo.findById(id).get(); }

    //delete by id
    public void deleteById(int id) { repo.deleteById(id); }
}
