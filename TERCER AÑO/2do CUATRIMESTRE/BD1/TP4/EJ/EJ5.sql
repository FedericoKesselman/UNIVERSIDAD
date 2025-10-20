CREATE TABLE appointments.APPOINTMENTS_PER_PATIENT (
    idApP integer(11) AUTO_INCREMENT PRIMARY KEY,
    id_patient integer(11),
    count_appointments integer(11),
    last_update datetime,
	user varchar(16)
    );
    