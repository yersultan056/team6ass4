package kz.aitu.carsharingass4demo.services.Interfaces;

import kz.aitu.carsharingass4demo.models.Booking;
import kz.aitu.carsharingass4demo.models.Cars;
import kz.aitu.carsharingass4demo.models.User;

import java.util.Date;
import java.util.List;

public interface BookingInterface {
    List<Booking> getAll();
    Booking getById(int id);
    Booking createBooking(User user, Cars car, Date startDate, Date endDate);
    List<Booking> getByUser(User user);
    List<Booking> getByCar(Cars car);

    boolean deleteBooking(int id);
    Booking updateBooking(Booking booking);
}
