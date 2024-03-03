package kz.aitu.carsharingass4demo.controllers;

import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceInterface service;

    // Constructor
    public CarsController(CarServiceInterface service) {
        this.service = service;
    }

    // Test endpoint
    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    // Get all cars
    @GetMapping("/")
    public List<Car> getAll(){
        return service.getAll();
    }

    // Get a car by ID
    @GetMapping("/{car_id}")
    public ResponseEntity<Car> getById(@PathVariable("car_id") int id){
        Car car = service.getById(id);
        if(car == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity(car, HttpStatus.OK);
    }

    // Create a new car
    @PostMapping("/")
    public ResponseEntity<Car> create(@RequestBody Car car){
        Car createdCar = service.create(car);
        if(createdCar == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    // Get all cars by brand
    @GetMapping("/brand/{car_brand}")
    public List<Car> getAllByBrand(@PathVariable("car_brand") String brand){
        return service.getByBrand(brand);
    }

    // Delete a car by ID
    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable int id){
        return service.deleteById(id);
    }

    // Update a car
    @PutMapping("/{car_id}")
    public ResponseEntity<Car> update(@PathVariable("car_id") int id, @RequestBody Car car) {
        Car updatedCar = service.updateCar(id, car);
        if(updatedCar == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    // Calculate the cost for a car for a specific period
    @GetMapping("/priceForPeriod/{id}/{period}/{period_number}")
    public String calculateCost(@PathVariable("id") int id, @PathVariable("period") String period, @PathVariable("period_number") int period_number){
        return "The cost for this car for a period of " + period_number + " " + period + " is " + service.calculateCost(id, period, period_number);
    }

    // Calculate the cost for a car from a specific start date to an end date
    @GetMapping("/priceForPeriodFromTo/{id}/{period_start}/{period_end}")
    public String calculateCostFromDate(@PathVariable("id") int id, @PathVariable("period_start") String period_start, @PathVariable("period_end") String period_end){
        return "The cost for this car for a period from " + period_start + " to " + period_end + " is " + service.calculateCostFromDate(id, period_start, period_end);
    }
}
