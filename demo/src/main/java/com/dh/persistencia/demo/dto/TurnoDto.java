package com.dh.persistencia.demo.dto;

import com.dh.persistencia.demo.entities.Odontologo;
import com.dh.persistencia.demo.entities.Paciente;

import java.util.Date;

public class TurnoDto {
    public Integer id;
    public Paciente paciente;
    public Odontologo odontologo;
    public Date fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
