package kz.aitu.carsharingass4demo.services;

import kz.aitu.carsharingass4demo.models.Cars;
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
    public List<Cars> getAll() {
        return repo.findAll();
    }

    @Override
    public Cars getByCarId(int carId) {
        return repo.findById(carId).orElse(null);
    }

    @Override
    public Cars createCar(Cars car) {
        return repo.save(car);
    }

    @Override
    public List<Cars> getByCarModel(String model) {
        return repo.findByModel(model);
    }

    @Override
    public List<Cars> getByCarBrand(String brand) {
        return repo.findByBrand(brand);
    }

    @Override
    public List<Cars> getByCarClass(String carClass) {
        return repo.findByCarClass(carClass);
    }

}
