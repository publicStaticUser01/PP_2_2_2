package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String showCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "Black", 300));
        cars.add(new Car("Mercedes", "Red", 250));
        cars.add(new Car("BMW", "White", 190));
        cars.add(new Car("Honda", "Grey", 215));
        cars.add(new Car("Volkswagen", "Green", 300));

        if (count != null && count >= 0 && count < cars.size()) {
            cars = cars.subList(0, count);
        }

        model.addAttribute("cars", cars);
        return "cars";
    }

}