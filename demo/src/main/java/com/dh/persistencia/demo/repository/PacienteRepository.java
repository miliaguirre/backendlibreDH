package com.dh.persistencia.demo.repository;

import com.dh.persistencia.demo.entities.Odontologo;
import com.dh.persistencia.demo.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
