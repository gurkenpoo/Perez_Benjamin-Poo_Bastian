package com.backend.clinicaodontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id del odontologo que se desea modificar")
    private Long id;

    @NotNull(message = "La matricula del odontólogo no puede ser nula")
    @NotBlank(message = "Debe especificarse la matricula del odontólogo")
    @Size(min = 10, message = "El campo debe tener mínimo 10 caracteres")
    private String matricula;

    @Size(max = 50, message = "El nombre del odontólogo debe tener hasta 50 caracteres")
    @NotNull(message = "El nombre de odontólogo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontólogo")
    private String nombre;

    @Size(max = 50, message = "El apellido de odontólogo debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido de odontólogo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del odontólogo")
    private String apellido;


    public OdontologoModificacionEntradaDto() {
    }

    public OdontologoModificacionEntradaDto(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
