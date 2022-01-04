package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Food;
import vnu.uet.cinema_manager.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public void setFoodRepository(FoodRepository foodRepository){
        this.foodRepository= foodRepository;
    }


    public List<Food> getAllFood(){
        return  foodRepository.findAll();
    }

    public void saveFood(Food food){
        foodRepository.save(food);
    }

    public Food getFoodById(Long id){
        Optional<Food> optional= foodRepository.findById(id);
        Food food= null;
        if(optional.isPresent()){
            food= optional.get();
        }else{
            throw new RuntimeException("Food not found for id: "+ id);
        }
        return food;
    }

    public void deletFoodById(Long id){
        foodRepository.deleteById(id);
    }
}
