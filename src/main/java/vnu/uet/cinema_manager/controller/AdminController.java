package vnu.uet.cinema_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vnu.uet.cinema_manager.entity.Cart;
import vnu.uet.cinema_manager.entity.Film;
import vnu.uet.cinema_manager.entity.FilmCalendar;
import vnu.uet.cinema_manager.entity.FoodDetail;
import vnu.uet.cinema_manager.service.*;

@Controller
public class AdminController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmCalendarService filmCalendarService;

    @Autowired
    private FoodDetailService foodDetailService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private CartService cartService;



    @GetMapping("/admin/manager/film")
    public String getFilm(Model model){
        model.addAttribute("listFilm", filmService.getAllFilm());
        return "admin/manager/film";
    }

    @GetMapping("/admin/manager/getFilmById")
    @ResponseBody
    public Film getFilmById(Long id){
        return filmService.getFilmById(id);
    }

    @PostMapping("/admin/manager/saveFilm")
    public String saveFilm(Film film){
        filmService.saveFilm(film);
        return "redirect:/admin/manager/film";
    }



    @GetMapping("/admin/manager/food")
    public String getFood(Model model){

        model.addAttribute("listFood", foodService.getAllFood());
        return "admin/manager/food";
    }
}
