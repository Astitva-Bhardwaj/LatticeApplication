package com.example.lattice.model;

import com.example.lattice.Enum.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name;

    @Size(max = 20, message = "City should be at most 20 characters")
    private String city;

    @Email(message = "Invalid email address")
    private String email;

    @Min(value = 1000000000L, message = "Phone number should be at least 10 digits")
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;


}