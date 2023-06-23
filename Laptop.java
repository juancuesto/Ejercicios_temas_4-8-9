package com.example.Ejercicio1_Sesion6.entity;

import javax.persistence.*;
@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fabricante;
    private String memoria;
    private String velocidad;
    private Double precio;

    public Laptop() {
    }

    public Laptop(Long id, String fabricante, String memoria, String velocidad, Double precio) {
        this.id = id;
        this.fabricante = fabricante;
        this.memoria = memoria;
        this.velocidad = velocidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
