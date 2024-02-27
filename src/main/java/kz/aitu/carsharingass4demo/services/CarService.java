package kz.aitu.carsharingass4demo.services;

import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.repositories.CarRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Car getByCarId(int carId) {
        return repo.findById(carId).orElse(null);
    }

    @Override
    public Car createCar(Car car) {
        return repo.save(car);
    }

    @Override
    public List<Car> getByCarModel(String model) {
        return repo.findByModel(model);
    }

    @Override
    public List<Car> getByCarBrand(String brand) {
        return repo.findByBrand(brand);
    }

    @Override
    public List<Car> getByCarClass(String carClass) {
        return repo.findByCarClass(carClass);
    }

    @Override
    public void deleteCar(int car_id) {
        repo.deleteById(car_id);
    }


}
