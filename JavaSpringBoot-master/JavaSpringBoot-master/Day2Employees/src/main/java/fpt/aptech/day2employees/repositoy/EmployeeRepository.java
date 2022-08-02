package fpt.aptech.day2employees.repositoy;

import fpt.aptech.day2employees.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
