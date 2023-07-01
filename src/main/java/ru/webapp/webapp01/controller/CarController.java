package ru.webapp.webapp01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webapp.webapp01.model.Car;
import ru.webapp.webapp01.service.CarService;


@Controller
@RequestMapping("/admin")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public String allCars(Model model){
        model.addAttribute("cars", carService.listCars());
        return "/admin";
    }

    @PostMapping
    public String createCar(@ModelAttribute("car") Car car){
        carService.add(car);
        return "redirect:/admin";
    }

    @PostMapping("/delete{id}")
    public String deleteCar(@PathVariable("id") Long id){
        carService.delete(id);
        return "redirect:/admin";
    }
}
