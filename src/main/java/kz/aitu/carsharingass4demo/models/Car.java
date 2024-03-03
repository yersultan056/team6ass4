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
    public String model;
    public String brand;
    public String car_class;
    public int orderer_id;
    public int owner_id;
    private int price;
}
