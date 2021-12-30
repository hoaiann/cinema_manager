package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vnu.uet.cinema_manager.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

//    @Query("select s from Admin a where a.user_username= ?1")
//    Admin findAdminByUsername(String username);
}
