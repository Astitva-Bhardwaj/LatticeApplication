## Prerequisites
Java 17
Maven
MySQL 

## API Endpoints
Add Patient:
POST /api/patients
Add a new patient to the system.

Remove Patient:
DELETE /api/patients/{patientId}
Remove a patient from the system.

Suggest Doctors:
GET /api/suggest-doctors/{patientId}
Get a list of suggested doctors based on patient's symptoms.
