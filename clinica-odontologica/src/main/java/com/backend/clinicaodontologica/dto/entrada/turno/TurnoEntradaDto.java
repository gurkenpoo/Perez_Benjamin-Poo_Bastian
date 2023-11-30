package com.backend.clinicaodontologica.dto.entrada.turno;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto {

    // Fecha y hora del turno
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaYHora;

    // Identificación del odontólogo asociado al turno
    @NotNull(message = "El turno tiene que tener un odontólogo registrado")
    private Long odontologoId;

    // Identificación del paciente asociado al turno
    @NotNull(message = "El turno tiene que tener un paciente registrado")
    private Long pacienteId;

    public TurnoEntradaDto(Long pacienteId, Long odontologoId, LocalDateTime fechaYHora) {
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fechaYHora = fechaYHora;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
