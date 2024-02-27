package kz.aitu.carsharingass4demo.repositories;

import kz.aitu.carsharingass4demo.models.Booking;
import kz.aitu.carsharingass4demo.models.Cars;
import kz.aitu.carsharingass4demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepositoryInterface extends JpaRepository<Booking, Integer> {
    List<Booking> findByUser(User user);
    List<Booking> findByCar(Cars car);

}
