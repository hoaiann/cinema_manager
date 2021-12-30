package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.cinema_manager.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
