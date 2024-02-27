package kz.aitu.carsharingass4demo.repositories;


import kz.aitu.carsharingass4demo.models.Car;
import kz.aitu.carsharingass4demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositoryInterface extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);

}
