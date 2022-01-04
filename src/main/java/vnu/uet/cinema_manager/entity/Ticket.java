package vnu.uet.cinema_manager.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private Integer slotLocation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSell;

    @ManyToOne
    @JoinColumn
    private FilmCalendar filmCalendar;

    @OneToOne
    @JoinColumn
    private FoodSold foodSold;

    @ManyToOne
    @JoinColumn
    private Cart cart;

    public Ticket(Integer slotLocation, LocalDate dateSell, FilmCalendar filmCalendar, FoodSold foodSold, Cart cart) {
        this.slotLocation = slotLocation;
        this.dateSell = dateSell;
        this.filmCalendar = filmCalendar;
        this.foodSold = foodSold;
        this.cart = cart;
    }

    public Ticket(Integer slotLocation, LocalDate dateSell, FilmCalendar filmCalendar, Cart cart) {
        this.slotLocation = slotLocation;
        this.dateSell = dateSell;
        this.filmCalendar = filmCalendar;
        this.cart = cart;
        this.foodSold= null;
    }

    public Ticket(Integer slotLocation, LocalDate dateSell, FilmCalendar filmCalendar) {
        this.slotLocation = slotLocation;
        this.dateSell = dateSell;
        this.filmCalendar = filmCalendar;
        this.cart = null;
        this.foodSold= null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(Integer slotLocation) {
        this.slotLocation = slotLocation;
    }

    public LocalDate getDateSell() {
        return dateSell;
    }

    public void setDateSell(LocalDate dateSell) {
        this.dateSell = dateSell;
    }

    public FilmCalendar getFilmCalendar() {
        return filmCalendar;
    }

    public void setFilmCalendar(FilmCalendar filmCalendar) {
        this.filmCalendar = filmCalendar;
    }

    public FoodSold getFoodSold() {
        return foodSold;
    }

    public void setFoodSold(FoodSold foodSold) {
        this.foodSold = foodSold;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
