package kz.aitu.carsharingass4demo.repositories;

import kz.aitu.carsharingass4demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositoryInterface extends JpaRepository<Car, Integer> {
    // Find all cars by their brand
    List<Car> findByBrand(String brand);
}
