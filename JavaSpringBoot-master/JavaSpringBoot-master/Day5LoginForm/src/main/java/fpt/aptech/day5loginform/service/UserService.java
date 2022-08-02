package fpt.aptech.day5loginform.service;

import fpt.aptech.day5loginform.model.User;
import fpt.aptech.day5loginform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    //show all user
    public List<User> showAll(){ return (List<User>) repo.findAll();}

    //insert or update
    public void InsertOrUpdate(User user){ repo.save(user);}

    //delete by id
    public void deleteByID(Long id){
        repo.deleteById(id);
    }

    //hàm search by id
    public User getUserById (Long id){
        return repo.findById(id).get();
    }
}
