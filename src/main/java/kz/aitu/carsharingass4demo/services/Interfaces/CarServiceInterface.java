package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAll();
    Car getById(int id);
    Car create(Car car);
    List<Car> getByBrand(String brand);
    String deleteById(int id);
}
