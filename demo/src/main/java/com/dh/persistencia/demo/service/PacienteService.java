package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.PacienteDto;
import com.dh.persistencia.demo.entities.Paciente;
import com.dh.persistencia.demo.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    public PacienteDto agregar(PacienteDto pacienteDto) {
        //conv dto a entity
        Paciente pacienteEntity = mapper.convertValue(pacienteDto, Paciente.class);
        //llamo al repository
        Paciente guardarEntity = pacienteRepository.save(pacienteEntity);
        //convertir de entity a dto
        PacienteDto pacienteCreadoDto = mapper.convertValue(guardarEntity, PacienteDto.class);

        return pacienteCreadoDto;
    }

    public List<PacienteDto> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDto> pacientesDtos = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            pacientesDtos.add(mapper.convertValue(paciente, PacienteDto.class));
        }

        return pacientesDtos;
    }

    public Optional<Paciente> buscarPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Paciente eliminar(Integer id) {
        Paciente paciente = null;
        if (pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
        }
        return paciente;
    }
}
