package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAll();
    User getById(int id);
    User create(User user);
    List<User> getBySurname(String surname);
}
