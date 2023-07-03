package com.Geekster.Hospital.Management.System.Repositories;

import com.Geekster.Hospital.Management.System.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
