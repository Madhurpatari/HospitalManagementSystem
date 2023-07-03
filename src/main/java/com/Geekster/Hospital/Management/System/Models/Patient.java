package com.Geekster.Hospital.Management.System.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Size(min = 3, message = "Name must have at least 3 characters")
    private String patientFirstName;

    private String patientLastName;

    private String city;

    @Email(message = "Email should be a valid email address")
    private String patientEmail;

    @Pattern(regexp = "\\d{10,}", message = "Phone number should have at least 10 digits")
    private String patientPhoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Symptom symptom;
}
