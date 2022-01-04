package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.User;
import vnu.uet.cinema_manager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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

    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUserById(String username){
        Optional<User> optional= userRepository.findById(username);
        User user= null;
        if(optional.isPresent()){
            user= optional.get();
        }
        return user;
    }

    public void deletUserById(String username){
        userRepository.deleteById(username);
    }
}
