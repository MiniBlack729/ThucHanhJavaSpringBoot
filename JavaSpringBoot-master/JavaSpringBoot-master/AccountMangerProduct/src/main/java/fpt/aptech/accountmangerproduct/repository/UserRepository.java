package fpt.aptech.accountmangerproduct.repository;

import fpt.aptech.accountmangerproduct.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsernameLike(String username);
}
