package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.service.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/turnos")
public class TurnoController {

    private final ITurnoService servicioTurno;

    public TurnoController(ITurnoService servicioTurno) {
        this.servicioTurno = servicioTurno;
    }

    //POST
    @Operation(summary = "Registro de un nuevo turno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turno registrado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@RequestBody @Valid TurnoEntradaDto dtoEntrada) throws BadRequestException, ResourceNotFoundException, ResourceNotFoundException {
        return new ResponseEntity<>(servicioTurno.registrarTurno(dtoEntrada), HttpStatus.CREATED);
    }

    //GET
    @Operation(summary = "Listar todos los turnos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turnos listados correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/listar")
    public ResponseEntity<List<TurnoSalidaDto>> listarTurnos(){
        return new ResponseEntity<>(servicioTurno.listarTurnos(), HttpStatus.OK);
    }

    //PUT
    @Operation(summary = "Actualizar datos de un turno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turno actualizado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PutMapping("/actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@RequestBody @Valid TurnoModificacionDto dtoModificacion) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(servicioTurno.actualizarTurno(dtoModificacion), HttpStatus.CREATED);
    }

    //GET
    @Operation(summary = "Buscar un turno por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turno encontrado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TurnoSalidaDto> buscarTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(servicioTurno.buscarTurnoPorId(id), HttpStatus.OK);
    }

    //DELETE
    @Operation(summary = "Eliminar un turno por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Turno eliminado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        servicioTurno.eliminarTurno(id);
        return new ResponseEntity<>("Turno eliminado correctamente", HttpStatus.NO_CONTENT);
    }
}