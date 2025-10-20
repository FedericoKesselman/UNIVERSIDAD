CREATE VIEW appointments.doctors_per_patients AS (
    SELECT d.doctor_id, p.patient_id, p.patient_city
    FROM doctor d INNER JOIN patient p ON d.doctor_city = p.patient_city
    )