package web.Service;

import web.models.Car;

import java.util.List;

public class CarServiceImpl implements CarService {


    @Override
    public List<Car> carsCount(List<Car> cars, int count) {
        return cars.stream().limit(count).toList();
    }
}
