package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Room;
import vnu.uet.cinema_manager.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRoom(){
        return  roomRepository.findAll();
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public Room getRoomById(Long id){
        Optional<Room> optional= roomRepository.findById(id);
        Room room= null;
        if(optional.isPresent()){
            room= optional.get();
        }else{
            throw new RuntimeException("Room not found for id: "+ id);
        }
        return room;
    }

    public void deletRoomById(Long id){
        roomRepository.deleteById(id);
    }
}
