package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vnu.uet.cinema_manager.entity.Film;
import vnu.uet.cinema_manager.entity.FilmCalendar;

public interface FilmCalendarRepository extends JpaRepository<FilmCalendar, Long> {
}
