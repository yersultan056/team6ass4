//package kz.aitu.carsharingass4demo.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Date;
//
//@Data
//@Entity
//@Table(name = "bookings")
//public class Booking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
//    private Cars car;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date startDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date endDate;
//
//
//}
