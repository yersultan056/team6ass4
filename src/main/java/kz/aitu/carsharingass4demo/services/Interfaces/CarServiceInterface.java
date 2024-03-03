package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Car;

import java.util.List;

public interface CarServiceInterface {
    // Get all cars
    List<Car> getAll();

    // Get a car by its ID
    Car getById(int id);

    // Create a new car
    Car create(Car car);

    // Get all cars by their brand
    List<Car> getByBrand(String brand);

    // Delete a car by its ID
    String deleteById(int id);

    // Update a car
    Car updateCar(int id, Car car);

    // Calculate the cost of renting a car for a specific period
    long calculateCost(int id, String period, long period_number);

    // Calculate the cost of renting a car from a specific start date to an end date
    long calculateCostFromDate(int id, String period_start, String period_end);
}

