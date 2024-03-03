package kz.aitu.carsharingass4demo.services;

import kz.aitu.carsharingass4demo.models.User;
import kz.aitu.carsharingass4demo.repositories.UserRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserService implements UserServiceInterface {
    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getBySurname(String surname) {
        return repo.findBySurname(surname);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        User existingUser = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.name != null) {
            existingUser.name = user.name;
        }
        if (user.surname != null) {
            existingUser.surname = user.surname;
        }
        existingUser.gender = user.gender;
        if (user.owns_cars != null) {
            existingUser.owns_cars = user.owns_cars;
        }
        if (user.ordered_cars != null) {
            existingUser.ordered_cars = user.ordered_cars;
        }

        return repo.save(existingUser);
    }
}
