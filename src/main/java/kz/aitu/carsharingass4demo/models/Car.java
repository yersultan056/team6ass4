package kz.aitu.carsharingass4demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier of the car

    public String model; // Model of the car
    public String brand; // Brand of the car
    public String car_class; // Class of the car
    public int orderer_id; // Identifier of the orderer
    public int owner_id; // Identifier of the owner
    private long price; // Price of the car
}
