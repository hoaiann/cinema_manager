package vnu.uet.cinema_manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vnu.uet.cinema_manager.model.TimeCalendar;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FilmCalendar {

    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCalendar;
    private TimeCalendar timeCalendar;


    @ManyToOne
    @JoinColumn
    private Film film;

    @OneToOne
    @JoinColumn
    private Room room;

    public FilmCalendar(LocalDate dateCalendar, TimeCalendar timeCalendar, Film film, Room room) {
        this.dateCalendar = dateCalendar;
        this.timeCalendar = timeCalendar;
        this.film = film;
        this.room = room;
    }

    public LocalDate getDateCalendar() {
        return dateCalendar;
    }

    public void setDateCalendar(LocalDate dateCalendar) {
        this.dateCalendar = dateCalendar;
    }

    public TimeCalendar getTimeCalendar() {
        return timeCalendar;
    }

    public void setTimeCalendar(TimeCalendar timeCalendar) {
        this.timeCalendar = timeCalendar;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
