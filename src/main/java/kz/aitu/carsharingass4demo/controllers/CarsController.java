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

    public CarsController(CarServiceInterface service) {
        this.service = service;
    }


    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/")
    public List<Car> getAll(){
        return service.getAll();
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<Car> getById(@PathVariable("car_id") int id){
        Car car = service.getById(id);
        if(car == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity(car, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<Car> create(@RequestBody Car car){
        Car createdCar = service.create(car);
        if(createdCar == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/brand/{car_brand}")
    public List<Car> getAllByBrand(@PathVariable("car_brand") String brand){
        return service.getByBrand(brand);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable int id){
        return service.deleteById(id);
    }

    @PutMapping("/{car_id}")
    public ResponseEntity<Car> update(@PathVariable("car_id") int id, @RequestBody Car car) {
        Car updatedCar = service.updateCar(id, car);
        if(updatedCar == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }




}
