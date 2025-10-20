-- usuario general para el TP
CREATE USER 'appointments_user'@'%' IDENTIFIED BY 'user123';
GRANT ALL PRIVILEGES ON appointments.* TO 'appointments_user'@'%';

-- usuario solo lectura (SELECT)
CREATE USER 'appointments_select'@'%' IDENTIFIED BY 'select123';
GRANT SELECT ON appointments.* TO 'appointments_select'@'%';

-- usuario que puede leer, insertar, modificar y borrar filas
CREATE USER 'appointments_update'@'%' IDENTIFIED BY 'update123';
GRANT SELECT, INSERT, UPDATE, DELETE ON appointments.* TO 'appointments_update'@'%';

-- usuario que además puede modificar el esquema (crear tablas, columnas, etc
CREATE USER 'appointments_schema'@'%' IDENTIFIED BY 'schema123';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP ON appointments.* TO 'appointments_schema'@'%';

-- Aplicar cambios
FLUSH PRIVILEGES;