package com.backend.clinicaodontologica.repository;

import com.backend.clinicaodontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    //@Query(value = "SELECT * FROM PACIENTES WHERE DNI = ?1", nativeQuery = true)
    //@Query("SELECT Paciente p FROM Paciente WHERE p.dni = ?1")
    Paciente findByDni(int dni);
}
