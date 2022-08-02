package fpt.aptech.day5loginform.repository;

import fpt.aptech.day5loginform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //create query findByUsername
    public User findByUsernameLike(String username);
}
