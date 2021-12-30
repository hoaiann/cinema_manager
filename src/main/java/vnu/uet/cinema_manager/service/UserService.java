package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.User;
import vnu.uet.cinema_manager.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username){
        return userRepository.findById(username).get();
    }
}
