package com.fernando.Herencia;

import jakarta.persistence.*;

@Entity
@DiscriminatorColumn(name = "vehiculo",discriminatorType = DiscriminatorType.STRING)
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehiculo;
    @Column(name = "cv")
    private int cv;
    @Column(name = "tipo")
    private String tipo;

    public Vehiculo() {
    }

    public Vehiculo(int cv, String tipo) {
        this.cv = cv;
        this.tipo = tipo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", cv=" + cv +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
