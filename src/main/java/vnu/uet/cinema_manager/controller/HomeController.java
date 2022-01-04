package vnu.uet.cinema_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vnu.uet.cinema_manager.entity.Film;
import vnu.uet.cinema_manager.service.FilmService;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    private FilmService filmService;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model){
        model.addAttribute("listResult", filmService.getAllFilm());

        // get list film with time
        model.addAttribute("listFilmAfter12",
                filmService.findAllByOpenDayBetween(
                        "2017-01-01",
                        "2021-11-30"
                ));
        model.addAttribute("listFilmIn12",
                filmService.findAllByOpenDayBetween(
                        "2021-12-01",
                        "2021-12-31"
                ));

        model.addAttribute("listFilm2022",
                filmService.findAllByOpenDayBetween(
                        "2022-01-01",
                        "2022-12-31"
                ));

        return "public/home";
    }

    @GetMapping("/film-details/{id}")
    public String showFormUpdateFilm(@PathVariable(value= "id") long id, Model model){
        // get employee from the service
        Film film= filmService.getFilmById(id);
        // set  employee as a model
        model.addAttribute("film", film);
        return "public/detailFilm";
    }


    @GetMapping(value = {"/about"})
    public String about(){
        return "public/about";
    }

    @GetMapping(value = {"/joinus"})
    public String joinus(){
        return "public/joinus";
    }

    @GetMapping(value = {"/contact"})
    public String contact(){
        return "public/contact";
    }

}
