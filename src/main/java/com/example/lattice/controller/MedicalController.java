package com.example.lattice.controller;



import com.example.lattice.model.Doctor;
import com.example.lattice.model.Patient;
import com.example.lattice.repo.PatientRepository;
import com.example.lattice.service.DoctorService;
import com.example.lattice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicalController {

    @Autowired
    private PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/patients")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            // Add custom logic for handling validation errors if needed
            return ResponseEntity.badRequest().body("Invalid patient details");
        }

        patientService.addPatient(patient);
        return ResponseEntity.ok("Patient added successfully");
    }

    @PostMapping("/doctors")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            // Add custom logic for handling validation errors if needed
            return ResponseEntity.badRequest().body("Invalid doctor details");
        }

        doctorService.addDoctor(doctor);
        return ResponseEntity.ok("Doctor added successfully");
    }


    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<String> removePatient(@PathVariable Long patientId) {
        // Add logic to remove patient
        patientService.removePatient(patientId);
        return ResponseEntity.ok("Patient removed successfully");
    }

    @GetMapping("/suggest-doctors/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        List<Doctor> suggestedDoctors = doctorService.findDoctorsByCityAndSymptom(patient.getCity(), patient.getSymptom());

        if (suggestedDoctors.isEmpty()) {
            return ResponseEntity.ok("There isn't any doctor present at your location for your symptom");
        } else {
            return ResponseEntity.ok(suggestedDoctors);
        }
    }
}
