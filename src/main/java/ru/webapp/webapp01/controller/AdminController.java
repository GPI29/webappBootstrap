package ru.webapp.webapp01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webapp.webapp01.model.User;
import ru.webapp.webapp01.service.UserDetailsServiceImpl;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public AdminController(UserDetailsServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping
    public String all(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailUser = user.getEmail();
        model.addAttribute("email", emailUser);
        model.addAttribute("users", userService.listUsers());
        return "admin";
    }

//    @PostMapping
//    public String createCar(@ModelAttribute("car") Car car){
//        carService.add(car);
//        return "redirect:/admin";
//    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/admin";
    }

    @PostMapping("/update{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @PostMapping("/deleteCar{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin";
    }
}