package kz.aitu.carsharingass4demo.repositories;

import kz.aitu.carsharingass4demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
    List<User> findBySurname(String surname);
}
