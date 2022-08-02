package fpt.aptech.camera.repository;

import fpt.aptech.camera.model.Camera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CameraRepository extends CrudRepository<Camera,String> {
    @Query("SELECT p FROM Camera p WHERE p.price >=?1 and p.price <=?2")
    public List<Camera> search(int from, int to);
}
