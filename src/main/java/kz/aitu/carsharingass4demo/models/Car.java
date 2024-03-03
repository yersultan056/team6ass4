package kz.aitu.carsharingass4demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String brand;
    private String car_class;
    private int price;
}
