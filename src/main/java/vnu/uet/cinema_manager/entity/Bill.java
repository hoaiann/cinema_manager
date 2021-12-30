package vnu.uet.cinema_manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    private Cart cart;

    @ManyToOne
    @JoinColumn
    private FoodDetail foodDetail;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;

}
