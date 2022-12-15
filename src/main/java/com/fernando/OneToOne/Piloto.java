package com.fernando.OneToOne;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pilotos")
public class Piloto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiloto;

    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "nacionalidad")
    private String nacionalidad;

    @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "piloto")
    private Coche coche;

    public Piloto() {
    }

    public Piloto(String nombre, String nacionalidad, Coche coche) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.coche = coche;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "idPiloto=" + idPiloto +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", coche=" + coche +
                '}';
    }
}
