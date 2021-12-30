package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.MyUserDetails;
import vnu.uet.cinema_manager.entity.User;
import vnu.uet.cinema_manager.repository.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user= userRepository.findById(username);
        user.orElseThrow( () -> new UsernameNotFoundException("Not found" + username));
        return user.map(MyUserDetails::new).get();
    }

}
