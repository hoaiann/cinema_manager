package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.FilmCalendar;
import vnu.uet.cinema_manager.entity.Room;
import vnu.uet.cinema_manager.entity.Ticket;
import vnu.uet.cinema_manager.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Ticket> getAllTicketSold(){
        return ticketRepository.getAllByDateSellNotNull();
    }

    public List<Ticket> getAllTicket(){
        return  ticketRepository.findAll();
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id){
        Optional<Ticket> optional= ticketRepository.findById(id);
        Ticket ticket= null;
        if(optional.isPresent()){
            ticket= optional.get();
        }else{
            throw new RuntimeException("Ticket not found for id: "+ id);
        }
        return ticket;
    }

    public void deletTicketById(Long id){
        ticketRepository.deleteById(id);
    }
}
