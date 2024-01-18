package com.example.lattice.service;

import com.example.lattice.Enum.Speciality;
import com.example.lattice.Enum.Symptom;
import com.example.lattice.model.Doctor;
import com.example.lattice.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findDoctorsByCityAndSymptom(String city, Symptom symptom) {
        // Basic logic to find doctors based on city and symptom
        return doctorRepository.findByCityAndSpeciality(city, getSpecialityForSymptom(symptom));
    }

    private Speciality getSpecialityForSymptom(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT_SPECIALIST;
            default:
                throw new IllegalArgumentException("Invalid symptom");
        }
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
