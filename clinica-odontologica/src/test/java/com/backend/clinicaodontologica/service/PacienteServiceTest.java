package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteDeNombreJuanYRetornarElId(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan", "Perez", 123456789, LocalDate.of(2023, 12, 24), new DomicilioEntradaDto("calle", 1234, "Localidad", "Provincia"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Juan", pacienteSalidaDto.getNombre());
    }


    @Test
    @Order(2)
    void alIntentarEliminarUnPacienteConId1YaEliminado_deberiaLanzarUnaResourceNotFoundException(){

        try{
            pacienteService.eliminarPaciente(1L);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDePacientes(){

        List<PacienteSalidaDto> pacientesDto = pacienteService.listarPacientes();

        assertTrue(pacientesDto.isEmpty());

    }



}