package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.FoodDetail;
import vnu.uet.cinema_manager.repository.FoodDetailRepository;

import java.util.List;
import java.util.Optional;


@Service
public class FoodDetailService {

    private FoodDetailRepository foodDetailRepository;

    @Autowired
    public void setFoodDetailRepository(FoodDetailRepository foodDetailRepository) {
        this.foodDetailRepository = foodDetailRepository;
    }

    public List<FoodDetail> getAllFoodDetail(){
        return  foodDetailRepository.findAll();
    }

    public void saveFoodDetail(FoodDetail foodDetail){
        foodDetailRepository.save(foodDetail);
    }

    public FoodDetail getFoodDetailById(Long id){
        Optional<FoodDetail> optional= foodDetailRepository.findById(id);
        FoodDetail foodDetail= null;
        if(optional.isPresent()){
            foodDetail= optional.get();
        }else{
            throw new RuntimeException("FoodDetail not found for id: "+ id);
        }
        return foodDetail;
    }

    public void deletFoodDetailById(Long id){
        foodDetailRepository.deleteById(id);
    }
}
