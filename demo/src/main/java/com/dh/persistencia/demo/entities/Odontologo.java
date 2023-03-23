package com.dh.persistencia.demo.entities;

import javax.persistence.*;

@Entity
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private int matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;






    public Odontologo() {
    }


    public Odontologo(Integer id, int matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }
}
