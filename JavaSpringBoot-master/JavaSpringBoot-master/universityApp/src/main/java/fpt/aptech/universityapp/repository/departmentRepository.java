package fpt.aptech.universityapp.repository;

import fpt.aptech.universityapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<Department,String> {
}
