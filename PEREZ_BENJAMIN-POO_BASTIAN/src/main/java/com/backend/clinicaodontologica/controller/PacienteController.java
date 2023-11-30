package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.service.IPacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService servicioPaciente;

    public PacienteController(IPacienteService servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<PacienteSalidaDto> registrarPaciente(@RequestBody @Valid PacienteEntradaDto dtoEntrada) {
        return new ResponseEntity<>(servicioPaciente.registrarPaciente(dtoEntrada), HttpStatus.CREATED);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> obtenerPacientePorId(@PathVariable Long id) {
        return new ResponseEntity<>(servicioPaciente.buscarPacientePorId(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteSalidaDto>> listarPacientes() {
        return new ResponseEntity<>(servicioPaciente.listarPacientes(), HttpStatus.OK);
    }

    //PUT
    @PutMapping("/actualizar")
    public PacienteSalidaDto actualizarPaciente(@RequestBody PacienteModificacionEntradaDto dtoModificacion) {
        return servicioPaciente.actualizarPaciente(dtoModificacion);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        servicioPaciente.eliminarPaciente(id);
        return new ResponseEntity<>("Paciente eliminado correctamente", HttpStatus.OK);
    }
}
