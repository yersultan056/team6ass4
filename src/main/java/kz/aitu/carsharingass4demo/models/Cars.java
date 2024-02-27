package kz.aitu.carsharingass4demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "cars")

public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;
    private String model;
    private String brand;
    private String car_class;
    private Integer order_id;
    private Integer owner_id;
}
