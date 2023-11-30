package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService<TurnoModificacionDto> {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException, ResourceNotFoundException;

    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(Long id) throws ResourceNotFoundException;
    TurnoSalidaDto actualizarTurno(TurnoModificacionDto turnoModificacionDto) throws ResourceNotFoundException, BadRequestException;

    TurnoSalidaDto actualizarTurno(com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionDto turnoModificacionDto) throws ResourceNotFoundException, BadRequestException;

    void eliminarTurno(Long id) throws ResourceNotFoundException;



}
