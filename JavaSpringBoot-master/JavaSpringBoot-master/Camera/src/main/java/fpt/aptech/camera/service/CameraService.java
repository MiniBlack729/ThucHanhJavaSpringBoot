package fpt.aptech.camera.service;

import fpt.aptech.camera.model.Camera;
import fpt.aptech.camera.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    @Autowired
    private CameraRepository repo;
    //ham show data
    public List<Camera> showAll(int from, int to){
        return repo.search(from,to);
    }

    public List<Camera> showAll(){
        return (List<Camera>) repo.findAll();
    }

    //ham tim product theo id
    public Camera getCameraById(String id){
        return repo.findById(id).get();
    }

    //ham xoa theo id
    public void delete(String id) {
        repo.deleteById(id);
    }
    //ham save or update
    public void SaveOrUpdate(Camera camera){
        repo.save(camera);
    }

}
