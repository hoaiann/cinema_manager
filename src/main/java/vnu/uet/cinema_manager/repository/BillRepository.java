package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vnu.uet.cinema_manager.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
