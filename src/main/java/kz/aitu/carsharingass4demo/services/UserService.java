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
        return null;
    }

    @Override
    public List<User> getBySurname(String surname) {
        return null;
    }
}
