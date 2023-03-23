package com.dh.persistencia.demo.controller;

import com.dh.persistencia.demo.dto.TurnoDto;
import com.dh.persistencia.demo.entities.Turno;
import com.dh.persistencia.demo.service.OdontologoService;
import com.dh.persistencia.demo.service.PacienteService;
import com.dh.persistencia.demo.service.TurnoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger LOGGER = LogManager.getLogger(PacienteController.class);
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<TurnoDto> registrarTurno(@RequestBody TurnoDto turnoDto) {
        LOGGER.info("Se creó un nuevo turno");
        Turno turnoGuardado = null;
        ResponseEntity<TurnoDto> response;
        // no encontre el paciente
        if (pacienteService.buscarPorId(turnoDto.getPaciente().getId()) == null
                && odontologoService.buscarPorId(turnoDto.getOdontologo().getId()) == null) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            response = ResponseEntity.ok(turnoService.agregar(turnoDto));
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TurnoDto>> mostrarTurnos() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Optional<Turno>> mostrarTurnoPorId(@PathVariable Integer id) {
        LOGGER.info(String.format("Turno encontrado, con id numero %s", id));
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<TurnoDto> eliminarTurno(@PathVariable Integer id){
        LOGGER.info(String.format("Turno eliminado exitosamente, id numero %s", id));
        turnoService.eliminar(id);
        ResponseEntity<TurnoDto> response;

        response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return response;
    }


}
