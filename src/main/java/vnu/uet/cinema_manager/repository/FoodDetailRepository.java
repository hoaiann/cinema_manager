package vnu.uet.cinema_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.cinema_manager.entity.FoodDetail;

public interface FoodDetailRepository extends JpaRepository<FoodDetail, Long> {
}
