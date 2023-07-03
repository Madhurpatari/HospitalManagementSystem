package com.Geekster.Hospital.Management.System.Repositories;

import com.Geekster.Hospital.Management.System.Models.Doctor;
import com.Geekster.Hospital.Management.System.Models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    List<Doctor> findAllByCityAndSpeciality(String city, Speciality speciality);
}
