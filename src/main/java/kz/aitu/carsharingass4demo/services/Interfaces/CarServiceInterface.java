package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAll();
    Car getById(int id);
    Car create(Car car);
    List<Car> getByBrand(String brand);
    String deleteById(int id);
    Car updateCar(int id, Car car);
    long calculateCost(int id, String period, long period_number);

    long calculateCostFromDate(int id, String period_start, String period_end);
}
