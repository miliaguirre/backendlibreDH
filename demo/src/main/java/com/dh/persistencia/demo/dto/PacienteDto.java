package com.dh.persistencia.demo.dto;

import java.util.Date;

public class PacienteDto {
    public Integer id;
    public String nombre;
    public String apellido;
    public int dni;
    public Date fechaDeAlta;



    public PacienteDto(String nombre, String apellido, int dni, Date fechaDeAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
}
