package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Film;
import vnu.uet.cinema_manager.repository.FilmRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository){
        this.filmRepository= filmRepository;
    }

    public List<Film> getAllFilm(){
        return  filmRepository.findAll();
    }

    public void saveFilm(Film film){
        film.setActive(true);
        filmRepository.save(film);
    }

    public List<Film> findAllByOpenDayBetween(String  dateStart, String dateEnd){
        return filmRepository.findFilmBetween(dateStart, dateEnd);
    }

    public Film getFilmById(Long id){
        Optional<Film> optional= filmRepository.findById(id);
        Film film= null;
        if(optional.isPresent()){
            film= optional.get();
        }else{
            throw new RuntimeException("Film not found for id: "+ id);
        }
        return film;
    }

    public void deletFilm(Long id){
        filmRepository.deleteById(id);
    }

}
