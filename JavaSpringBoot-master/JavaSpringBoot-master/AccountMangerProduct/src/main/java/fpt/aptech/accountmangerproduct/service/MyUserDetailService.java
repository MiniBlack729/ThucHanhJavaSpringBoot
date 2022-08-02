package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.Role;
import fpt.aptech.accountmangerproduct.model.User;
import fpt.aptech.accountmangerproduct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // check user account if exist or not in db User
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameLike(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        MyUserDetail myUserDetail = new MyUserDetail(user);
        return myUserDetail;
    }
}
