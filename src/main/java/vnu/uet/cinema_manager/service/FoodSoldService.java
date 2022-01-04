package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.FoodSold;
import vnu.uet.cinema_manager.repository.FoodSoldRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodSoldService {

    private FoodSoldRepository foodSoldRepository;

    @Autowired
    public void setFoodSoldRepository(FoodSoldRepository foodSoldRepository) {
        this.foodSoldRepository = foodSoldRepository;
    }

    public List<FoodSold> getAllFoodSold(){
        return  foodSoldRepository.findAll();
    }

    public void saveFoodSold(FoodSold foodSold){
        foodSoldRepository.save(foodSold);
    }

    public FoodSold getFoodSoldById(Long id){
        Optional<FoodSold> optional= foodSoldRepository.findById(id);
        FoodSold foodSold= null;
        if(optional.isPresent()){
            foodSold= optional.get();
        }else{
            throw new RuntimeException("FoodSold not found for id: "+ id);
        }
        return foodSold;
    }

    public void deletFoodSoldById(Long id){
        foodSoldRepository.deleteById(id);
    }
}
