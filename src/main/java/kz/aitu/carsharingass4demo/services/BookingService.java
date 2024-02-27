package kz.aitu.carsharingass4demo.services;

import kz.aitu.carsharingass4demo.models.Booking;
import kz.aitu.carsharingass4demo.models.Cars;
import kz.aitu.carsharingass4demo.models.User;
import kz.aitu.carsharingass4demo.repositories.BookingRepositoryInterface;
import kz.aitu.carsharingass4demo.services.Interfaces.BookingInterface;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService implements BookingInterface {
    private final BookingRepositoryInterface repo;

    public BookingService(BookingRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Booking> getAll() {
        return repo.findAll();
    }

    @Override
    public Booking getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Booking createBooking(User user, Cars car, Date startDate, Date endDate) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setCar(car);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        return repo.save(booking);
    }

    @Override
    public List<Booking> getByUser(User user) {
        return repo.findByUser(user);
    }

    @Override
    public List<Booking> getByCar(Cars car) {
        return repo.findByCar(car);
    }
    @Override
    public boolean deleteBooking(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Booking updateBooking(Booking booking) {
        if (booking.getId() == 0) {
            throw new IllegalArgumentException("Invalid booking id");
        }
        return repo.save(booking);
    }
}
