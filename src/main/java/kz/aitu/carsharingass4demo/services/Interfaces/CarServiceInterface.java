package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAll();
    Car getByCarId(int carId);
    Car createCar(Car car);
    List<Car> getByCarModel(String model);
    List<Car> getByCarBrand(String brand);
    List<Car> getByCarClass(String carClass);
    void deleteCar(int carId);
}
