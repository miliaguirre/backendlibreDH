package com.dh.persistencia.demo.controller;

import com.dh.persistencia.demo.dto.PacienteDto;
import com.dh.persistencia.demo.entities.Paciente;
import com.dh.persistencia.demo.service.PacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private static final Logger LOGGER = LogManager.getLogger(PacienteController.class);

    @Autowired
    PacienteService pacienteService;


    @PostMapping("/registrar")
    public ResponseEntity<PacienteDto> registrarPaciente(@RequestBody PacienteDto pacienteDto) {
        LOGGER.info("Se creó un nuevo paciente");
        return ResponseEntity.ok(pacienteService.agregar(pacienteDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteDto>> mostrarPacientes() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Optional<Paciente>> mostrarPacientePorId(@PathVariable Integer id) {
        LOGGER.info(String.format("Paciente encontrado con id numero %s", id));
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PacienteDto> eliminarTurno(@PathVariable Integer id){
        LOGGER.info(String.format("Paciente eliminado exitosamente, id numero %s", id));
        pacienteService.eliminar(id);
        ResponseEntity<PacienteDto> response;

        response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return response;
    }
}
