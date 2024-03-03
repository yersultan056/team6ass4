package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAll(); // Get all users
    User getById(int id); // Get a user by ID
    User create(User user); // Create a new user
    List<User> getBySurname(String surname); // Get all users by surname
    void deleteById(int id); // Delete a user by ID
    User updateUser(int id, User user); // Update a user
}

