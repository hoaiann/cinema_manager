package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Food;
import vnu.uet.cinema_manager.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public void setFoodRepository(FoodRepository foodRepository){
        this.foodRepository= foodRepository;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
