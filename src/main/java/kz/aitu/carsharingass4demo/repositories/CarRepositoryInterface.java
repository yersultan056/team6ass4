package kz.aitu.carsharingass4demo.repositories;

import kz.aitu.carsharingass4demo.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositoryInterface extends JpaRepository<Cars, Integer> {
    List<Cars> findByModel(String model);
    List<Cars> findByBrand(String brand);
    List<Cars> findByCarClass(String carClass);
}
