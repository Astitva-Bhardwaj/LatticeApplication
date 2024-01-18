package com.example.lattice.service;



import com.example.lattice.model.Doctor;
import com.example.lattice.model.Patient;
import com.example.lattice.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorService doctorService;

    public Patient addPatient(Patient patient) {
        // Basic logic to add a patient
        return patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        // Basic logic to remove a patient
        patientRepository.deleteById(patientId);
    }

    public List<Doctor> suggestDoctorsForPatient(Long patientId) {
        // Basic logic to suggest doctors for a patient based on their symptom
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }

        return doctorService.findDoctorsByCityAndSymptom(patient.getCity(), patient.getSymptom());
    }
}

