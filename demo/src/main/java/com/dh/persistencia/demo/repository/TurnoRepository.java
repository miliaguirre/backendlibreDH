package com.dh.persistencia.demo.repository;

import com.dh.persistencia.demo.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
