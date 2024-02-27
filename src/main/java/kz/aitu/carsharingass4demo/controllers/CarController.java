package kz.aitu.carsharingass4demo.controllers;

import kz.aitu.carsharingass4demo.services.Interfaces.CarServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kz.aitu.carsharingass4demo.models.Cars;

import java.util.List;
@RestController
@RequestMapping("cars")
public class CarController {
    private final CarServiceInterface service;

    public CarController(CarServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Cars> getAll() {
        return service.getAll();
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<Cars> getById(@PathVariable("car_id") int carId) {
        Cars car = service.getByCarId(carId);
        if (car == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Cars> create(@RequestBody Cars car) {
        Cars createdCar = service.createCar(car);
        if (createdCar == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/model/{car_model}")
    public List<Cars> getAllByModel(@PathVariable("car_model") String model) {
        return service.getByCarModel(model);
    }

    @GetMapping("/brand/{car_brand}")
    public List<Cars> getAllByBrand(@PathVariable("car_brand") String brand) {
        return service.getByCarBrand(brand);
    }

    @GetMapping("/class/{car_class}")
    public List<Cars> getAllByCarClass(@PathVariable("car_class") String carClass) {
        return service.getByCarClass(carClass);
    }

}
