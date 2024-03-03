package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAll(); // Get all cars
    Car getById(int id); // Get a car by ID
    Car create(Car car); // Create a new car
    List<Car> getByBrand(String brand); // Get all cars by brand
    String deleteById(int id); // Delete a car by ID
    Car updateCar(int id, Car car); // Update a car
    long calculateCost(int id, String period, long period_number); // Calculate the cost for a car for a specific period
    long calculateCostFromDate(int id, String period_start, String period_end); // Calculate the cost for a car from a specific start date to an end date
}


