package kz.aitu.carsharingass4demo.controllers;

import kz.aitu.carsharingass4demo.models.Booking;
import kz.aitu.carsharingass4demo.models.Cars;
import kz.aitu.carsharingass4demo.models.User;
import kz.aitu.carsharingass4demo.services.Interfaces.BookingInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingController {

    private final BookingInterface service;

    public BookingController(BookingInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Booking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<Booking> getById(@PathVariable("booking_id") int id) {
        Booking booking = service.getById(id);
        if (booking == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Booking> create(@RequestParam("user_id") int userId,
                                          @RequestParam("car_id") int carId,
                                          @RequestParam("start_date") Date startDate,
                                          @RequestParam("end_date") Date endDate) {
        User user = new User();
        Cars car = new Cars();
        Booking createdBooking = service.createBooking(user, car, startDate, endDate);
        if (createdBooking == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/user/{user_id}")
    public List<Booking> getByUser(@PathVariable("user_id") int userId) {
        User user = new User();
        return service.getByUser(user);
    }

    @GetMapping("/car/{car_id}")
    public List<Booking> getByCar(@PathVariable("car_id") int carId) {
        Cars car = new Cars();
        return service.getByCar(car);
    }
}
