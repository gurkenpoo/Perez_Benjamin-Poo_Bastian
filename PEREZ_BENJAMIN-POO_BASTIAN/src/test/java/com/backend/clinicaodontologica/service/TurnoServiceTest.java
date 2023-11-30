package com.backend.clinicaodontologica.service;

import static org.junit.jupiter.api.Assertions.*;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TurnoServiceTest {

    @Test
    void deberiaCrearTurnoEntradaDtoCorrectamente() {
        // Arrange
        Long pacienteId = 1L;
        Long odontologoId = 2L;
        LocalDateTime fechaYHora = LocalDateTime.of(2023, 12, 24, 10, 30);

        // Act
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(pacienteId, odontologoId, fechaYHora);

        // Assert
        assertNotNull(turnoEntradaDto);
        assertEquals(pacienteId, turnoEntradaDto.getPacienteId());
        assertEquals(odontologoId, turnoEntradaDto.getOdontologoId());
        assertEquals(fechaYHora, turnoEntradaDto.getFechaYHora());
    }

    @Test
    void deberiaSetearPacienteIdCorrectamente() {
        // Arrange
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L, 2L, LocalDateTime.now());
        Long nuevoPacienteId = 3L;

        // Act
        turnoEntradaDto.setPacienteId(nuevoPacienteId);

        // Assert
        assertEquals(nuevoPacienteId, turnoEntradaDto.getPacienteId());
    }

    @Test
    void deberiaSetearOdontologoIdCorrectamente() {
        // Arrange
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L, 2L, LocalDateTime.now());
        Long nuevoOdontologoId = 4L;

        // Act
        turnoEntradaDto.setOdontologoId(nuevoOdontologoId);

        // Assert
        assertEquals(nuevoOdontologoId, turnoEntradaDto.getOdontologoId());
    }

    @Test
    void deberiaSetearFechaYHoraCorrectamente() {
        // Arrange
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L, 2L, LocalDateTime.now());
        LocalDateTime nuevaFechaYHora = LocalDateTime.of(2023, 12, 25, 14, 45);

        // Act
        turnoEntradaDto.setFechaYHora(nuevaFechaYHora);

        // Assert
        assertEquals(nuevaFechaYHora, turnoEntradaDto.getFechaYHora());
    }
}