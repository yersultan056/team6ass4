package kz.aitu.carsharingass4demo.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier of the user

    public String name; // Name of the user
    public String surname; // Surname of the user
    public boolean gender; // Gender of the user (true for male, false for female)
    public List<Integer> owns_cars; // List of IDs of cars owned by the user
    public List<Integer> ordered_cars; // List of IDs of cars ordered by the user
}