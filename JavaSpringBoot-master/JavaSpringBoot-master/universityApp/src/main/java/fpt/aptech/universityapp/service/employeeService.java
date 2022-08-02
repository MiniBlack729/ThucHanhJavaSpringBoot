package fpt.aptech.universityapp.service;

import fpt.aptech.universityapp.model.Employee;
import fpt.aptech.universityapp.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    public employeeRepository emprepo;
    public List<Employee>findAll(){
        return emprepo.findAll();
    }
    public void save(Employee employee){
        emprepo.save(employee);
    }
}
