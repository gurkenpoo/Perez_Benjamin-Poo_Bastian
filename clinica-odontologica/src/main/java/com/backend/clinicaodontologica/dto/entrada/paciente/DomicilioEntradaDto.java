package com.backend.clinicaodontologica.dto.entrada.paciente;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DomicilioEntradaDto {

    // Nombre de la calle
    @NotNull(message = "El campo calle no puede ser nulo")
    @NotBlank(message = "El campo calle no puede estar en blanco")
    private String calle;

    // Número de la dirección
    @NotNull(message = "El campo numero no puede ser nulo")
    @Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
    private Integer numero;

    // Localidad de la dirección
    @NotNull(message = "El campo localidad no puede ser nulo")
    @NotBlank(message = "El campo localidad no puede estar en blanco")
    private String localidad;

    // Provincia de la dirección
    @NotNull(message = "El campo provincia no puede ser nulo")
    @NotBlank(message = "El campo provincia no puede estar en blanco")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    // Métodos getter y setter con los nombres originales
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}