package fpt.aptech.universityapp.repository;

import fpt.aptech.universityapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee,Long> {
}
