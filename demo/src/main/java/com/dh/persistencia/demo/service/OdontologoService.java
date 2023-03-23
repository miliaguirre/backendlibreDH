package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.OdontologoDto;
import com.dh.persistencia.demo.entities.Odontologo;
import com.dh.persistencia.demo.exception.ResourceNotFoundException;
import com.dh.persistencia.demo.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public OdontologoDto agregar(OdontologoDto odontologoDto) {
        //conv dto a entity
        Odontologo odontologoEntity = mapper.convertValue(odontologoDto, Odontologo.class);
        //llamo al repository
        Odontologo guardarEntity = odontologoRepository.save(odontologoEntity);
        //convertir de entity a dto
        OdontologoDto odontologoCreadoDto = mapper.convertValue(guardarEntity, OdontologoDto.class);

        return odontologoCreadoDto;
    }
    public List<OdontologoDto> listar() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        List<OdontologoDto> odontologosDtos = new ArrayList<>();

        for (Odontologo odontologo : odontologos) {
            odontologosDtos.add(mapper.convertValue(odontologo, OdontologoDto.class));
        }

        return odontologosDtos;
    }
    /*public OdontologoDto buscarPorId (Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDto odontologoDto = null;
        if (odontologo.isPresent()) {
            odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);
        }
        return odontologoDto;
    }*/
    public Optional<Odontologo> buscarPorId (Integer id) {

        LOGGER.info(String.format("Se encontró el odontólogo con id %s", id));
        return odontologoRepository.findById(id);
    }

    public OdontologoDto modificar(OdontologoDto odontologoDto) throws ResourceNotFoundException {
        Odontologo odontologoActualizar = mapper.convertValue(odontologoDto, Odontologo.class);
        if(odontologoDto.getId() == null){
            throw new ResourceNotFoundException ("No se puede actualizar el odontologo " + odontologoDto.getId());
        }
        Odontologo odontologoActualizado = odontologoRepository.save(odontologoActualizar);
        return mapper.convertValue(odontologoActualizado, OdontologoDto.class);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if(!buscarPorId(id).isPresent()){
            throw new ResourceNotFoundException ("No existe el odontologo con el id nro = " + id);
        } odontologoRepository.deleteById(id);
    }

}
