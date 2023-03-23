package com.dh.persistencia.demo.controller;

import com.dh.persistencia.demo.dto.OdontologoDto;
import com.dh.persistencia.demo.entities.Odontologo;
import com.dh.persistencia.demo.exception.ResourceNotFoundException;
import com.dh.persistencia.demo.service.OdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private static final Logger LOGGER = LogManager.getLogger(OdontologoController.class);

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDto> registrarPaciente(@RequestBody OdontologoDto odontologoDto) {
        LOGGER.info("Se creó un nuevo odontologo");
        return ResponseEntity.ok(odontologoService.agregar(odontologoDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OdontologoDto>> mostrarOdontologos() throws ResourceNotFoundException {
        List<OdontologoDto> listaDeOdontologos = odontologoService.listar();
        if (listaDeOdontologos.isEmpty()){
            LOGGER.info("No hay odontologos");
        }
        LOGGER.info("Se encontraron estos odontologos " + listaDeOdontologos.size());
        return ResponseEntity.ok(listaDeOdontologos);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Optional<Odontologo>> mostrarOdontologoPorId(@PathVariable Integer id) {
        LOGGER.info(String.format("Odontologo encontrado, con id numero %s", id));
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<OdontologoDto> actualizarOdontologo(@PathVariable Integer id, @RequestBody OdontologoDto odontologoDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.modificar(odontologoDto));

    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id)  throws ResourceNotFoundException, Exception{
        LOGGER.info(String.format("Odontologo eliminado exitosamente, id numero %s", id));
        odontologoService.eliminar(id);

        return ResponseEntity.status(HttpStatus.OK).body("Eliminado correctamente");
    }


}
