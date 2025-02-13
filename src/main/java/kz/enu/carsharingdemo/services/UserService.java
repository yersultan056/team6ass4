package kz.enu.carsharingdemo.services;
import kz.enu.carsharingdemo.models.User;
import kz.enu.carsharingdemo.repositories.UserRepositoryInterface;
import kz.enu.carsharingdemo.services.Interfaces.UserServiceInterface;
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

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getSurname() != null) {
            existingUser.setSurname(user.getSurname());
        }
        return repo.save(existingUser);
    }
}

