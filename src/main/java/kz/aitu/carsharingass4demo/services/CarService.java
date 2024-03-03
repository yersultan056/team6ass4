package kz.aitu.carsharingass4demo.services;

import jakarta.transaction.Transactional;
import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.models.User;
import kz.aitu.carsharingass4demo.repositories.CarRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CarService implements CarServiceInterface {
    private final CarRepositoryInterface repo;

    public CarService(CarRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Car> getAll() {
        return repo.findAll();
    }

    @Override
    public Car getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Car create(Car car) {
        return repo.save(car);
    }

    @Override
    public List<Car> getByBrand(String brand) {
        return repo.findByBrand(brand);
    }

    @Override
    public String deleteById(int id){
        repo.deleteById(id);
        return "Car " + " deleted";
    }

    @Override
    public int calculateCost(int id, String period, int period_number){
        Car car = getById(id);
        if(Objects.equals(period, "hour")){
            return car.getPrice() * (period_number * 60);
        } else if (Objects.equals(period, "day")) {
            return (car.getPrice() * 250) * period_number;
        }else if (Objects.equals(period, "month")) {
            return (car.getPrice() * 125) * (period_number * 30);
        }
        return 0;
    }


}
