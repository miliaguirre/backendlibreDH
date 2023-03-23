package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.TurnoDto;
import com.dh.persistencia.demo.entities.Turno;
import com.dh.persistencia.demo.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private static final Logger LOGGER = LogManager.getLogger(TurnoService.class);
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }



    public TurnoDto agregar(TurnoDto turnoDto) {
        //conv dto a entity
        Turno turnoEntity = mapper.convertValue(turnoDto, Turno.class);
        //llamo al repository
        Turno entity = turnoRepository.save(turnoEntity);
        //conv de entity a dto
        TurnoDto turnoCreadoDto = mapper.convertValue(entity, TurnoDto.class);

        return turnoCreadoDto;
    }
    public List<TurnoDto> listar() {
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDto> turnosDtos = new ArrayList<>();

        for (Turno turno : turnos) {
            turnosDtos.add(mapper.convertValue(turno, TurnoDto.class));
        }

        return turnosDtos;
    }


    public Optional<Turno> buscarPorId(Integer id) {
        return turnoRepository.findById(id);
    }



    public Turno modificar(Turno turno) {
        return null;
    }


    public String eliminar(Integer id) {

        if (turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
            return "Turno con el id: " + id + "eliminado exitosamente";
        }
        return "Turno con el id: " + id + "no existe";
    }


}
