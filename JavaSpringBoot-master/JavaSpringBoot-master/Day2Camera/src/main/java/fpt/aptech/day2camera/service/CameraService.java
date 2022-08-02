package fpt.aptech.day2camera.service;

import fpt.aptech.day2camera.model.Camera;
import fpt.aptech.day2camera.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraService {
    @Autowired
    private CameraRepository repo;

    //hàm showAll
    public List<Camera> showAll(){
        List<Camera> cameras = new ArrayList<Camera>();
        repo.findAll().forEach(camera -> cameras.add(camera)); //chạy luôn for each add vào, ko cần ép kiểu
        return cameras;
    }

    //hàm search by id
    public Camera getCameraById (String id){
        return repo.findById(id).get();
    }

    //hàm save or update
    public void SaveOrUpdate(Camera camera){
        repo.save(camera);
    }

    //delete by id
    public void deleteByID(String id){
        repo.deleteById(id);
    }

    //search by price from..to
    public  List<Camera> showByPrice(int from, int to){ return repo.findAllByPriceBetween(from, to); }

    //search by name
    public List<Camera> showByName(String name){ return repo.findAllByNameLike(name); }
}
