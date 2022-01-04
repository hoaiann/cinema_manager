package vnu.uet.cinema_manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cmnd;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean male;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRegister;

    @OneToOne
    @JoinColumn
    private Cart Cart;

    @OneToOne
    @JoinColumn
    private User user;

    public Customer(String cmnd, String fullName, String phone, String email, String address, boolean male, LocalDate dateRegister, vnu.uet.cinema_manager.entity.Cart cart, User user) {
        this.cmnd = cmnd;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.male = male;
        this.dateRegister = dateRegister;
        Cart = cart;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public vnu.uet.cinema_manager.entity.Cart getCart() {
        return Cart;
    }

    public void setCart(vnu.uet.cinema_manager.entity.Cart cart) {
        Cart = cart;
    }

    public boolean isMale() {
        return male;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
