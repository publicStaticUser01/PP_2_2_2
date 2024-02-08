package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.models.Car;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = (count != null) ? carService.getCars(count) : carService.getCars(Integer.MAX_VALUE);
        model.addAttribute("cars", cars);
        return "cars";
    }
}