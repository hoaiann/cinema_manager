package vnu.uet.cinema_manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vnu.uet.cinema_manager.model.Size;
import vnu.uet.cinema_manager.model.Status;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FoodDetail {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Size size;
    private BigDecimal price;
    private Integer count;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean active;

    @ManyToOne
    @JoinColumn
    private Food food;

    public FoodDetail(Size size, BigDecimal price, Integer count, boolean active, Food food) {
        this.size = size;
        this.price = price;
        this.count = count;
        this.active = active;
        this.food = food;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
