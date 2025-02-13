package kz.enu.carsharingdemo.repositories;
import kz.enu.carsharingdemo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepositoryInterface extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);



}
