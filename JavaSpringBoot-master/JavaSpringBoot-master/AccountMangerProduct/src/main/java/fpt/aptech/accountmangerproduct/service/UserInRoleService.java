package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.Role;
import fpt.aptech.accountmangerproduct.model.UserInRole;
import fpt.aptech.accountmangerproduct.repository.UserInRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInRoleService {
    @Autowired
    private UserInRoleRepository userInRoleRepository;

    //show all user role
    public List<UserInRole> findAllUserRole(){
        return userInRoleRepository.findAll();
    }

    //get role by userId
    public UserInRole getRoleByUserID(Long userId){ return userInRoleRepository.findById(userId).get(); }

    //add role access for user
    public void SaveOrUpdateRole(UserInRole userInRole){ userInRoleRepository.save(userInRole); }

    //delete role truoc khi xoa user
    public void deleteUserRoleByUserId(Long userId){ userInRoleRepository.deleteById(userId);}
}
