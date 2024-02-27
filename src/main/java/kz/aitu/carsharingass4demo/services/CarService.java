package kz.aitu.carsharingass4demo.services;

import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.repositories.CarRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

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
    public Car update(int id, Car car) {
        Car existingCar = repo.findById(id).orElse(null);
        if (existingCar != null) {
            BeanUtils.copyProperties(car, existingCar, "id");
            return repo.save(existingCar);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
