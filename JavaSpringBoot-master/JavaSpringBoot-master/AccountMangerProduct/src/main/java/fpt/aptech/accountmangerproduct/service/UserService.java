package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.User;
import fpt.aptech.accountmangerproduct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId){ return userRepository.findById(userId); }

    public void SaveOrUpdate(User user){ userRepository.save(user); }

    public void deleteUserById(Long userId){ userRepository.deleteById(userId);}
}
