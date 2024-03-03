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
    private int id;
    public String name;
    public String surname;
    public boolean gender;
    public List<Integer> owns_cars;
    public List<Integer> ordered_cars;
}
