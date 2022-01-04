package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vnu.uet.cinema_manager.entity.FoodSold;

@Repository
public interface FoodSoldRepository extends JpaRepository<FoodSold, Long> {
}
