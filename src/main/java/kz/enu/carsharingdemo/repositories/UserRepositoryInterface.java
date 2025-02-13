package kz.enu.carsharingdemo.repositories;

import kz.enu.carsharingdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
    // Find all users by their surname
    List<User> findBySurname(String surname);
}
