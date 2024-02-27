package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Cars;

import java.util.List;

public interface CarServiceInterface {
    List<Cars> getAll();
    Cars getByCarId(int carId);
    Cars createCar(Cars car);
    List<Cars> getByCarModel(String model);
    List<Cars> getByCarBrand(String brand);
    List<Cars> getByCarClass(String carClass);
    void deleteCar(int carId);
}
