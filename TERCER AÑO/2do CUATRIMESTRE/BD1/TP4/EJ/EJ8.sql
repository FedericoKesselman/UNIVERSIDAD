DELIMITER //

CREATE TRIGGER update_appointments_per_patient_after_insert 
    AFTER INSERT
    ON appointment FOR EACH ROW 
    BEGIN
        UPDATE appointments.APPOINTMENTS_PER_PATIENT 
        SET 
            count_appointments = count_appointments + 1,
            last_update = NOW(),
            user = CURRENT_USER()
        WHERE id_patient = NEW.patient_id;
    END //
    
DELIMITER ;