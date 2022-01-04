package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vnu.uet.cinema_manager.entity.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "select * " +
            "from film f " +
            "where f.open_day  >= ?1 and f.open_day <= ?2",
            nativeQuery = true)
    List<Film> findFilmBetween(String dateStart, String dateEnd);
}
