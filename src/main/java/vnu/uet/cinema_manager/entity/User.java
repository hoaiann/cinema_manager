package vnu.uet.cinema_manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    private String username;
    private String password;
    private String roles;
    private boolean isActive;


    private User (String username, String password, boolean isActive, String roles){
      this.username= username;
      this.password= password;
      this.isActive= isActive;
      this.roles= roles;
    }

    public User(String username){
        this.username= username;
        this.password= username;
        this.isActive= true;
        this.roles="ROLE_CUSTOMER";
    }


    public User(String username, String roles){
        this.username= username;
        this.password= username;
        this.isActive= true;
        this.roles=roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
