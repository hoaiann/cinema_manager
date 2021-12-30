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
public class Film {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String directors;
    private String actors;
    private String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate openDay;
    private String time;
    private BigDecimal price;
    @Lob
    private String description;
    private String banner;
    private boolean isActive;

    public Film(String name, String directors, String actors, String category, LocalDate openDay, String time, BigDecimal price, String description, String banner) {
        this.name = name;
        this.directors = directors;
        this.actors = actors;
        this.category = category;
        this.openDay = openDay;
        this.time = time;
        this.price = price;
        this.description = description;
        this.banner = banner;
        this.isActive= true;
    }

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getOpenDay() {
        return openDay;
    }

    public void setOpenDay(LocalDate openDay) {
        this.openDay = openDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
