SELECT p.patient_id, p.patient_name 
FROM patient p
WHERE NOT EXISTS (
    	SELECT 1
    	FROM appointment a 
    	WHERE a.patient_id = p.patient_id AND a.contact_phone <> p.primary_phone
    )