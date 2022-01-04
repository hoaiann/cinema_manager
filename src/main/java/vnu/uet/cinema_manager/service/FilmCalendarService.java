package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Film;
import vnu.uet.cinema_manager.entity.FilmCalendar;
import vnu.uet.cinema_manager.entity.Room;
import vnu.uet.cinema_manager.model.TimeCalendar;
import vnu.uet.cinema_manager.repository.FilmCalendarRepository;
import vnu.uet.cinema_manager.repository.TicketRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FilmCalendarService {

    private FilmCalendarRepository filmCalendarRepository;

    @Autowired
    public void setFilmCalendarRepository(FilmCalendarRepository filmCalendarRepository){
        this.filmCalendarRepository= filmCalendarRepository;
    }

    public List<FilmCalendar> getAllFilmCalendar(){
        return  filmCalendarRepository.findAll();
    }

    public void saveFilmCalendar(FilmCalendar filmCalendar){
        filmCalendarRepository.save(filmCalendar);
    }

    public FilmCalendar getFilmCalendarById(Long id){
        Optional<FilmCalendar> optional= filmCalendarRepository.findById(id);
        FilmCalendar filmCalendar= null;
        if(optional.isPresent()){
            filmCalendar= optional.get();
        }else{
            throw new RuntimeException("FilmCalendar not found for id: "+ id);
        }
        return filmCalendar;
    }

    public void deletFilmCalendarById(Long id){
        filmCalendarRepository.deleteById(id);
    }
}
