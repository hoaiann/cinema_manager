package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.cinema_manager.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
