package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OdontologoEntradaDtoTest {

    @Test
    void deberiaCrearOdontologoEntradaDtoCorrectamente() {
        // Arrange
        String matricula = "1234567890";
        String nombre = "Juan";
        String apellido = "Perez";

        // Act
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto(matricula, nombre, apellido);

        // Assert
        assertNotNull(odontologoEntradaDto);
        assertEquals(matricula, odontologoEntradaDto.getMatricula());
        assertEquals(nombre, odontologoEntradaDto.getNombre());
        assertEquals(apellido, odontologoEntradaDto.getApellido());
    }

    @Test
    void deberiaSetearMatriculaCorrectamente() {
        // Arrange
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("1234567890", "Juan", "Perez");
        String nuevaMatricula = "0987654321";

        // Act
        odontologoEntradaDto.setMatricula(nuevaMatricula);

        // Assert
        assertEquals(nuevaMatricula, odontologoEntradaDto.getMatricula());
    }

    @Test
    void deberiaSetearNombreCorrectamente() {
        // Arrange
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("1234567890", "Juan", "Perez");
        String nuevoNombre = "Maria";

        // Act
        odontologoEntradaDto.setNombre(nuevoNombre);

        // Assert
        assertEquals(nuevoNombre, odontologoEntradaDto.getNombre());
    }

    @Test
    void deberiaSetearApellidoCorrectamente() {
        // Arrange
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("1234567890", "Juan", "Perez");
        String nuevoApellido = "Gomez";

        // Act
        odontologoEntradaDto.setApellido(nuevoApellido);

        // Assert
        assertEquals(nuevoApellido, odontologoEntradaDto.getApellido());
    }
}