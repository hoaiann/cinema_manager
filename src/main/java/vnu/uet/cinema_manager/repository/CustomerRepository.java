package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vnu.uet.cinema_manager.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query("select s from Customer c where c.user_username= ?1")
//    Customer findUserByUsername(String username);
}
