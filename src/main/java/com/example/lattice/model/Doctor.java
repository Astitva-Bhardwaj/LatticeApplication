package com.example.lattice.model;

import com.example.lattice.Enum.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
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
    private Speciality speciality;

}