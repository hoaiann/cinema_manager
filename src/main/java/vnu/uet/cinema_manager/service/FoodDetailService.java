package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.repository.FoodDetailRepository;


@Service
public class FoodDetailService {

    private FoodDetailRepository foodDetailRepository;

    @Autowired
    public void setFoodDetailRepository(FoodDetailRepository foodDetailRepository) {
        this.foodDetailRepository = foodDetailRepository;
    }
}
