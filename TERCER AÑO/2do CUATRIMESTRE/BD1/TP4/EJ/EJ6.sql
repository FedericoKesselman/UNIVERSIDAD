DELIMITER //

CREATE PROCEDURE load_appointments_per_patient()
BEGIN
    -- Variables
    DECLARE v_id_patient INT;
    DECLARE v_count INT;
    DECLARE v_fecha DATETIME;
    DECLARE v_user VARCHAR(50);
    DECLARE fin INT DEFAULT 0;

    -- Cursor
    DECLARE cur CURSOR FOR 
        SELECT patient_id, COUNT(*)
        FROM appointment
        GROUP BY patient_id;

    -- Handlers
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
        ROLLBACK;
    END;

    -- Usuario actual y fecha actual
    SET v_user = CURRENT_USER();
    SET v_fecha = NOW();

    START TRANSACTION;

    -- Iterar cursor
    OPEN cur;
    loop_cur: LOOP
        FETCH cur INTO v_id_patient, v_count;
        IF fin = 1 THEN
            LEAVE loop_cur; 
        END IF;

        INSERT INTO appointments.APPOINTMENTS_PER_PATIENT 
            (id_patient, count_appointments, last_update, user)
        VALUES 
            (v_id_patient, v_count, v_fecha, v_user);
    END LOOP;
    CLOSE cur;

    COMMIT;
END //

DELIMITER ;