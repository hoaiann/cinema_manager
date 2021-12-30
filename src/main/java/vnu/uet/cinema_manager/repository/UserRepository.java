package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.cinema_manager.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
