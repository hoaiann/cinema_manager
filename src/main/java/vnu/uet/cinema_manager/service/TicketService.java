package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.FilmCalendar;
import vnu.uet.cinema_manager.entity.Room;
import vnu.uet.cinema_manager.entity.Ticket;
import vnu.uet.cinema_manager.repository.TicketRepository;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository){
        this.ticketRepository= ticketRepository;
    }

    public void createTicketWhenCreateFilmCalendar(FilmCalendar filmCalendar){
        int totalSlot= filmCalendar.getRoom().getSlot();
        for(int i=1; i<=totalSlot; i++){
            ticketRepository.save(new Ticket(i, null, filmCalendar));
        }
    }
}
