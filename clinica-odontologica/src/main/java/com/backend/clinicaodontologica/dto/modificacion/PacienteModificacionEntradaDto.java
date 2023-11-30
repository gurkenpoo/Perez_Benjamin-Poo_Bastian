package com.backend.clinicaodontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id del paciente que se desea modificar")
    private Long id;

    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del paciente")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;

    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del paciente")
    private String apellido;

    @NotNull(message = "El dni del paciente no puede ser nulo")
    @Size(max = 12, message = "El nombre debe tener hasta 12 digitos")
    private Integer dni;

    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private DomicilioModificacionEntradaDto domicilioModificacionEntradaDto;

    public PacienteModificacionEntradaDto() {
    }

    public PacienteModificacionEntradaDto(Long id, String nombre, String apellido, Integer dni, LocalDate fechaIngreso, DomicilioModificacionEntradaDto domicilioEntradaDto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioModificacionEntradaDto = domicilioEntradaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    public DomicilioModificacionEntradaDto getDomicilioModificacionEntradaDto() {
        return domicilioModificacionEntradaDto;
    }

    public void setDomicilioModificacionEntradaDto(DomicilioModificacionEntradaDto domicilioModificacionEntradaDto) {
        this.domicilioModificacionEntradaDto = domicilioModificacionEntradaDto;
    }
}
