package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.OdontologoDto;
import com.dh.persistencia.demo.entities.Odontologo;
import com.dh.persistencia.demo.exception.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    public OdontologoDto crearOdontologo(){
        return this.odontologoService.agregar(new OdontologoDto("Melisa","Rabadan",11011));
    }

    @Test
    public void guardarOdontologo(){
        OdontologoDto odontologoDto = this.crearOdontologo();

        Assert.assertTrue(odontologoDto.getId() != null);
    }
    @Test
    public void listarTodos(){
        OdontologoDto odontologoDto = this.crearOdontologo();
        List<OdontologoDto> listaOdontologos = this.odontologoService.listar();

        Assert.assertTrue(!listaOdontologos.isEmpty());

        Assert.assertTrue(listaOdontologos.size() >= 1);
    }
    @Test
    public void buscar() throws ResourceNotFoundException {
        OdontologoDto odontologoDto = this.crearOdontologo();
        Optional<Odontologo> buscarOdontologo = this.odontologoService.buscarPorId(odontologoDto.getId());

        Assert.assertTrue(buscarOdontologo.isPresent());
    }
    @Test
    public void eliminar() throws ResourceNotFoundException {
        OdontologoDto odontologoDto = this.crearOdontologo();
        this.odontologoService.eliminar(odontologoDto.getId());

        Assert.assertTrue(this.odontologoService.buscarPorId(odontologoDto.getId()).isPresent());
    }
}
