DELIMITER //
CREATE PROCEDURE register_appointment (
    IN p_patient_id INTEGER, 
    IN p_doctor_id INTEGER, 
    IN p_appointment_duration INTEGER, 
    IN p_contact_phone VARCHAR(50), 
    IN p_appointment_address VARCHAR(50), 
    IN p_medication_name VARCHAR(50)) 
BEGIN
    -- Variables 
    DECLARE v_appointment_date DATETIME;

    -- Handler
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
        ROLLBACK;
    END;
    
    SET v_appointment_date = NOW();

    START TRANSACTION;
        -- Appointment (tmb se podria haber agregar la direccion dentro de observations)
        INSERT INTO appointments.appointment
            (patient_id, appointment_date, appointment_duration, contact_phone, observations, payment_card) 
        VALUES 
            (p_patient_id, v_appointment_date, p_appointment_duration, p_contact_phone, NULL, NULL);

        -- Medical review
        INSERT INTO appointments.medical_review 
            (patient_id, appointment_date, doctor_id)
        VALUES
            (p_patient_id, v_appointment_date, p_doctor_id);
        
        -- Prescribed medication
        INSERT INTO appointments.prescribed_medication
            (patient_id, appointment_date, medication_name)
        VALUES
            (p_patient_id, v_appointment_date, p_medication_name);

    COMMIT;
END