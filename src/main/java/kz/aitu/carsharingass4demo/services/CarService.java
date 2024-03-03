package kz.aitu.carsharingass4demo.services;

import jakarta.transaction.Transactional;
import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.repositories.CarRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String deleteById(int id){
        repo.deleteById(id);
        return "Car " + " deleted";
    }
    @Override
    public Car updateCar(int id, Car car) {
        Car existingCar = repo.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));

        if (car.model != null) {
            existingCar.model = car.model;
        }
        if (car.brand != null) {
            existingCar.brand = car.brand;
        }
        if (car.car_class != null) {
            existingCar.car_class = car.car_class;
        }
        if (car.orderer_id != 0) {
            existingCar.orderer_id = car.orderer_id;
        }
        if (car.owner_id != 0) {
            existingCar.owner_id = car.owner_id;
        }

        return repo.save(existingCar);
    }


}
