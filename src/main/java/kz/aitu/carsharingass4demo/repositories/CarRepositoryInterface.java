package kz.aitu.carsharingass4demo.repositories;

import kz.aitu.carsharingass4demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositoryInterface extends JpaRepository<Car, Integer> {
    List<Car> findByModel(String model);
    List<Car> findByBrand(String brand);
    List<Car> findByCarClass(String carClass);
}
