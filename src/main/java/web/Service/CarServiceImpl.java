package web.Service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> createCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "Black", 300));
        cars.add(new Car("Mercedes", "Red", 250));
        cars.add(new Car("BMW", "White", 190));
        cars.add(new Car("Honda", "Grey", 215));
        cars.add(new Car("Volkswagen", "Green", 300));
        return cars;
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = createCarList();
        if (count >= 0 && count < cars.size()) {
            return cars.subList(0, count);
        }
        return cars;
    }
}