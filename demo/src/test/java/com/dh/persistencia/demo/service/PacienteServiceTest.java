package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.PacienteDto;
import com.dh.persistencia.demo.entities.Paciente;
import com.dh.persistencia.demo.exception.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    public PacienteDto crear() {
        return this.pacienteService.agregar(new PacienteDto("Prueba","Test",1234567,new Date(2022-12-12)));
    }
    @Test
    public void crearPaciente(){
        PacienteDto pacienteDto = this.crear();
        Assert.assertTrue(pacienteDto.getId() != null);
    }
    @Test
    public void listarTodos(){
        List<PacienteDto> listPatient = this.pacienteService.listar();
        Assert.assertTrue(!listPatient.isEmpty());
        Assert.assertTrue(listPatient.size() >= 1);
    }
    @Test
    public void buscar() throws ResourceNotFoundException {
        PacienteDto pacienteDto = this.crear();
        Optional<Paciente> searchPatient = this.pacienteService.buscarPorId(pacienteDto.getId());
        Assert.assertTrue(searchPatient.isPresent());
    }
    @Test
    public void eliminar() throws ResourceNotFoundException {
        PacienteDto pacienteDto = this.crear();
        this.pacienteService.eliminar(pacienteDto.getId());

        Assert.assertTrue(this.pacienteService.buscarPorId(pacienteDto.getId()).isPresent());

    }
}
