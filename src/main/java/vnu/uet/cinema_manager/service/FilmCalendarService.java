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

@Service
public class FilmCalendarService {

    private FilmCalendarRepository filmCalendarRepository;

    @Autowired
    public void setFilmCalendarRepository(FilmCalendarRepository filmCalendarRepository){
        this.filmCalendarRepository= filmCalendarRepository;
    }
    
}
