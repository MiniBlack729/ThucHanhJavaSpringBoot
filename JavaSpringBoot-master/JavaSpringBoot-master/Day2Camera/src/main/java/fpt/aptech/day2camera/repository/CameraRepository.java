package fpt.aptech.day2camera.repository;

import fpt.aptech.day2camera.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, String> {
    //tạo query search price
    public List<Camera> findAllByPriceBetween(int from, int to);

    //tạo query search name
    public List<Camera> findAllByNameLike(String keyword);
}
