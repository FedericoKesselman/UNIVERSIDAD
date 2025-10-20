-- A:
SELECT patient_id, patient_city, COUNT(doctor_id) as Cantidad_Doctores
FROM doctors_per_patients
GROUP BY patient_id

-- B:
SELECT p.patient_id, p.patient_name
FROM patient p LEFT JOIN doctors_per_patients dp ON p.patient_id = dp.patient_id
GROUP BY p.patient_id, p.patient_name
HAVING COUNT(dp.doctor_id) = 0

-- C: 
SELECT doctor_id 
FROM doctors_per_patients 
GROUP BY doctor_id
HAVING COUNT(patient_id) > 5