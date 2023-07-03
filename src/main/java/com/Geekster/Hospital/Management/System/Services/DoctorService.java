package com.Geekster.Hospital.Management.System.Services;

import com.Geekster.Hospital.Management.System.Models.Doctor;
import com.Geekster.Hospital.Management.System.Models.Speciality;
import com.Geekster.Hospital.Management.System.Models.Symptom;
import com.Geekster.Hospital.Management.System.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public List<Doctor> findDoctorsByCityAndSymptom(String city, Symptom symptom) {
        Speciality speciality = getSpecialityFromSymptom(symptom);
        List<Doctor> doctors = doctorRepository.findAllByCityAndSpeciality(city, speciality);
        if (doctors.isEmpty()) {
            if (!isLocationSupported(city)) {
                throw new LocationNotSupportedException("We are still waiting to expand to your location");
            } else {
                throw new NoDoctorAvailableException("There isn't any doctor present at your location for your symptom");
            }
        }
        return doctors;
    }

    private boolean isLocationSupported(String city) {
        return city.equalsIgnoreCase("Delhi") ||
                city.equalsIgnoreCase("Noida") ||
                city.equalsIgnoreCase("Faridabad");
    }

    private Speciality getSpecialityFromSymptom(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT_SPECIALIST;
            default -> throw new IllegalArgumentException("Invalid symptom");
        };
    }

}
