## Hospital Management System

The Hospital Management System is a platform that allows doctors to register their patients through a mobile or web portal. This project provides backend APIs for adding doctors, adding patients with their symptoms, and suggesting doctors based on patient symptoms and location.

### Technologies Used

- Spring Boot: Framework for building the backend APIs
- Hibernate: ORM (Object-Relational Mapping) library for database operations
- Swagger: Optional tool for documenting and testing the APIs

###  Setup

1. Clone the repository:

```shell
git clone <repository-url>
```
1. Configure the database connection in the application.properties file.

1. Build and run the project:
```shell
cd hospital-management-system
./mvnw spring-boot:run
```
The application will start running on http://localhost:8080. You can access the API documentation (Swagger UI) at http://localhost:8080/swagger-ui.html.
### API Endpoints
#### Doctor
- POST /doctors: Add a new doctor.
- DELETE /doctors/{doctorId}: Remove a doctor from the platform.
#### Patient
- POST /patients: Add a new patient with their symptoms.
- DELETE /patients/{patientId}: Remove a patient from the platform.
#### Suggesting Doctors
- GET /suggested-doctors/{patientId}: Get a list of suggested doctors based on a patient's symptom and location.
### validations
- Name: Should be at least 3 characters.
- City (Doctor): Should be one of the values: Delhi, Noida, Faridabad.
- City (Patient): No restrictions.
- Email: Should be a valid email address.
- Phone Number: Should be at least 10 digits.
### Edge Cases
- If there aren't any doctors available in the patient's location (outside Delhi, Noida, Faridabad), the response will be "We are still waiting to expand to your location."
- If there aren't any doctors available in the patient's location for their symptom, the response will be "There isn't any doctor present at your location for your symptom."
### Contributing
Contributions to the Hospital Management System project are welcome! If you find any issues or want to add new features, please feel free to submit a pull request.