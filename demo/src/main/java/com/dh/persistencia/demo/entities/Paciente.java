package com.dh.persistencia.demo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private int dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    private Date fechaDeAlta;
    private String domicilio;



    public Paciente() {
    }


    public Paciente(int dni, String nombre, String apellido, Date fechaDeAlta, String domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeAlta = fechaDeAlta;
        this.domicilio = domicilio;
    }

    public Integer getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
