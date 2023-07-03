package com.Geekster.Hospital.Management.System.Controllers;

import com.Geekster.Hospital.Management.System.Models.Doctor;
import com.Geekster.Hospital.Management.System.Models.Patient;
import com.Geekster.Hospital.Management.System.Repositories.DoctorRepository;
import com.Geekster.Hospital.Management.System.Repositories.PatientRepository;
import com.Geekster.Hospital.Management.System.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;


    @PostMapping("/doctors")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
        return new ResponseEntity<>("Doctor added successfully.!!", HttpStatus.CREATED);
    }
    @PostMapping("/patients")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient){
        patientRepository.save(patient);
        return new ResponseEntity<>("Patient added successfully.!!", HttpStatus.CREATED);
    }

    @GetMapping("/suggested-doctors/{patientId}")
    public ResponseEntity<List<Doctor>> suggestDoctorForPatient(@PathVariable Long patientId){
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()->new IllegalArgumentException("No patient found"));

        List<Doctor> suggestedDoctors = doctorService.findDoctorsByCityAndSymptom(patient.getCity(), patient.getSymptom());
        if(suggestedDoctors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        }else {
            return ResponseEntity.ok(suggestedDoctors);
        }
    }
}
