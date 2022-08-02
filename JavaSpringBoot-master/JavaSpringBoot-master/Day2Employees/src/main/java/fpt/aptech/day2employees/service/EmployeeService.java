package fpt.aptech.day2employees.service;

import fpt.aptech.day2employees.model.Employee;
import fpt.aptech.day2employees.repositoy.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    //hàm showAll
    public List<Employee> showAll(){
        List<Employee> employees = new ArrayList<Employee>();
        repo.findAll().forEach(employee -> employees.add(employee)); //chạy luôn for each
        return employees;
    }

    //hàm search by id
    public Employee getEmployeeById (Long Id){
        return repo.findById(Id).get();
    }

    //hàm save or update
    public void SaveOrUpdate(Employee employee){
        repo.save(employee);
    }

    //delete by id
    public void deleleByID(Long id){
        repo.deleteById(id);
    }
}
