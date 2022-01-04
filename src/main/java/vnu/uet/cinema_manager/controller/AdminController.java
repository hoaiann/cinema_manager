package vnu.uet.cinema_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vnu.uet.cinema_manager.entity.*;
import vnu.uet.cinema_manager.service.*;

import java.time.LocalDate;

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
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private BillService billService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FoodSoldService foodSoldService;

    //bill

    @GetMapping("/admin/statistic/food")
    public String getFoodStatistic(Model model){
        model.addAttribute("listFoodSold", foodSoldService.getAllFoodSold());
        return "admin/statistic/food";
    }

    //ticket
    @GetMapping("/admin/statistic/ticket")
    public String getTicketStatistic(Model model){
        model.addAttribute("listTicket", ticketService.getAllTicket());
        return "admin/statistic/ticket";
    }

    //bill
    @GetMapping("/admin/statistic/bill")
    public String getBillStatistic(Model model){
        model.addAttribute("listTicketSold", ticketService.getAllTicketSold());
        return "admin/statistic/bill";
    }

    //cart
    @GetMapping("/admin/manager/cart")
    public String getCart(Model model){
        model.addAttribute("listCart", cartService.getAllCart());
        return "admin/manager/cart";
    }

    @GetMapping("/admin/manager/getCartById")
    @ResponseBody
    public Cart getCartById(Long id){
        return cartService.getCartById(id);
    }

    @PostMapping("/admin/manager/saveCart")
    public String saveCart(Cart cart){
        cartService.saveCart(cart);
        return "redirect:/admin/manager/cart";
    }
    // customer
    @GetMapping("/admin/manager/customer")
    public String getCustomer(Model model){
        model.addAttribute("listCustomer", customerService.getAllCustomer());
        return "admin/manager/customer";
    }

    @GetMapping("/admin/manager/getCustomerById")
    @ResponseBody
    public Customer getCustomerById(Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/admin/manager/saveCustomer")
    public String saveCustomer(Customer customer, User userFromThymeleaf){
        // add date register
        if(customer.getDateRegister()== null){
            customer.setDateRegister(LocalDate.now());
        }

        User user = new User(userFromThymeleaf.getUsername());
        user.setRoles(userFromThymeleaf.getRoles());
        user.setActive(userFromThymeleaf.getActive());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        customer.setUser(user);

        Cart cart= new Cart();
        cartService.saveCart(cart);
        customer.setCart(cart);
        customerService.saveCustomer(customer);
        return "redirect:/admin/manager/customer";
    }

    @PostMapping("/admin/manager/editCustomer")
    public String saveCustomer(Customer customer, User userFromThymeleaf, Cart cartFromThymeleaf){

        User userInDB= userService.getUserById(userFromThymeleaf.getUsername());
        userInDB.setRoles(userFromThymeleaf.getRoles());
        userInDB.setActive(userFromThymeleaf.getActive());

        userService.saveUser(userInDB);

        Cart cartInDB= cartService.getCartById(cartFromThymeleaf.getCartId());

        customer.setUser(userInDB);
        customer.setCart(cartInDB);
        customerService.saveCustomer(customer);
        return "redirect:/admin/manager/customer";
    }


    // film
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

    // filmCalendar
    @GetMapping("/admin/manager/filmCalendar")
    public String getFilmCalendar(Model model){
        model.addAttribute("listFilmCalendar", filmCalendarService.getAllFilmCalendar());
        model.addAttribute("listFilm", filmService.getAllFilm());
        model.addAttribute("listRoom", roomService.getAllRoom());
        return "admin/manager/filmCalendar";
    }

    @GetMapping("/admin/manager/getFilmCalendarById")
    @ResponseBody
    public FilmCalendar getFilmCalendarById(Long id){
        return filmCalendarService.getFilmCalendarById(id);
    }

    @PostMapping("/admin/manager/saveFilmCalendar")
    public String saveFilmCalendar(FilmCalendar filmCalendar, Long idFilm, Long idRoom){
        Film filmInDB= filmService.getFilmById(idFilm);
        Room roomInDB= roomService.getRoomById(idRoom);
        filmCalendar.setFilm(filmInDB);
        filmCalendar.setRoom(roomInDB);

        filmCalendarService.saveFilmCalendar(filmCalendar);
        return "redirect:/admin/manager/filmCalendar";
    }

    @PostMapping("/admin/manager/editFilmCalendar")
    public String editFilmCalendar(FilmCalendar filmCalendarFromThymeleaf, Long idFilm, Long idRoom){
        FilmCalendar filmCalendarInDB= filmCalendarService.getFilmCalendarById(filmCalendarFromThymeleaf.getId());
        Film filmInDB= filmService.getFilmById(idFilm);
        Room roomInDB= roomService.getRoomById(idRoom);
        filmCalendarInDB.setFilm(filmInDB);
        filmCalendarInDB.setRoom(roomInDB);

        filmCalendarService.saveFilmCalendar(filmCalendarInDB);
        return "redirect:/admin/manager/filmCalendar";
    }



    // food
    @GetMapping("/admin/manager/food")
    public String getFood(Model model){
        model.addAttribute("listFood", foodService.getAllFood());
        model.addAttribute("listFoodDetail", foodDetailService.getAllFoodDetail());
        return "admin/manager/food";
    }

    @GetMapping("/admin/manager/getFoodById")
    @ResponseBody
    public Food getFoodById(Long id){
        return foodService.getFoodById(id);
    }

    @PostMapping("/admin/manager/saveFood")
    public String saveFood(Food food){
        foodService.saveFood(food);
        return "redirect:/admin/manager/food";
    }

    // foodDetail
    @GetMapping("/admin/manager/foodDetail")
    public String getFoodDetail(Model model){
        model.addAttribute("listFoodDetail", foodDetailService.getAllFoodDetail());
        model.addAttribute("listFood", foodService.getAllFood());
        return "admin/manager/foodDetail";
    }

    @GetMapping("/admin/manager/getFoodDetailById")
    @ResponseBody
    public FoodDetail getFoodDetailById(Long id){
        return foodDetailService.getFoodDetailById(id);
    }

    @PostMapping("/admin/manager/saveFoodDetail")
    public String saveFoodDetail(FoodDetail foodDetail1Thymeleaf, Long idFood){

        Food foodInDB = foodService.getFoodById(idFood);
        FoodDetail foodDetail= new FoodDetail(
                foodDetail1Thymeleaf.getSize(),
                foodDetail1Thymeleaf.getPrice(),
                foodDetail1Thymeleaf.getCount(),
                foodDetail1Thymeleaf.isActive(),
                foodInDB
        );
        foodDetailService.saveFoodDetail(foodDetail);
        return "redirect:/admin/manager/foodDetail";
    }

    @PostMapping("/admin/manager/editFoodDetail")
    public String editFoodDetail(FoodDetail foodDetailFromThymeleaf, String idFood){
        FoodDetail foodDetail1InDb= foodDetailService.getFoodDetailById(foodDetailFromThymeleaf.getId());
        foodDetail1InDb.setCount(foodDetailFromThymeleaf.getCount());
        foodDetail1InDb.setActive(foodDetailFromThymeleaf.isActive());
        foodDetail1InDb.setPrice(foodDetailFromThymeleaf.getPrice());
        foodDetailService.saveFoodDetail(foodDetail1InDb);
        return "redirect:/admin/manager/foodDetail";
    }
    // ticket
    @GetMapping("/admin/manager/ticket")
    public String getTicket(Model model){
        model.addAttribute("listTicket", ticketService.getAllTicket());
        return "admin/manager/ticket";
    }

    @GetMapping("/admin/manager/getTicketById")
    @ResponseBody
    public Ticket getTicketById(Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping("/admin/manager/saveTicket")
    public String saveTicket(Ticket ticket){
        ticketService.saveTicket(ticket);
        return "redirect:/admin/manager/ticket";
    }



    // room
    @GetMapping("/admin/manager/room")
    public String getRoom(Model model){
        model.addAttribute("listRoom", roomService.getAllRoom());
        return "admin/manager/room";
    }

    @GetMapping("/admin/manager/getRoomById")
    @ResponseBody
    public Room getRoomById(Long id){
        return roomService.getRoomById(id);
    }

    @PostMapping("/admin/manager/saveRoom")
    public String saveRoom(Room room){
        roomService.saveRoom(room);
        return "redirect:/admin/manager/room";
    }
    // user
    @GetMapping("/admin/manager/user")
    public String getUser(Model model){
        model.addAttribute("listUser", userService.getAllUser());
        return "admin/manager/user";
    }

    @GetMapping("/admin/manager/getUserById")
    @ResponseBody
    public User getUserById(String username){
        return userService.getUserById(username);
    }

    @PostMapping("/admin/manager/saveUser")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/admin/manager/user";
    }




}
