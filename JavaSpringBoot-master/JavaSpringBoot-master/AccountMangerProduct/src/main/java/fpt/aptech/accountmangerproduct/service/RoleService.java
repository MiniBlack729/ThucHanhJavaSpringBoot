package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.Role;
import fpt.aptech.accountmangerproduct.repository.RoleRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepositoy roleRepositoy;
    public List<Role> findAll(){
        return roleRepositoy.findAll();
    }

    //get role by id
    public Role getRoleById(Long roleId) {return roleRepositoy.findById(roleId).get(); }
}
