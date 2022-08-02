package fpt.aptech.universityapp.service;

import fpt.aptech.universityapp.model.Department;
import fpt.aptech.universityapp.repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentService {
    @Autowired
    public departmentRepository departmentRepositoryrepo;
    public List<Department>findAll(){
        return departmentRepositoryrepo.findAll();
    }
}
