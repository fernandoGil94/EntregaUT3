package com.fernando.OneToMany;

import com.fernando.OneToOne.Coche;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "escuderias")
public class Escuderia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEscuderia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "AñoDebut")
    private int anyoDebut;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "escuderia")
    private List<Coche> coches;

    public Escuderia() {
    }

    public Escuderia(String nombre, int anyoDebut, List<Coche> coches) {
        this.nombre = nombre;
        this.anyoDebut = anyoDebut;
        this.coches = coches;
    }

    public int getIdEscuderia() {
        return idEscuderia;
    }

    public void setIdEscuderia(int idEscuderia) {
        this.idEscuderia = idEscuderia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoDebut() {
        return anyoDebut;
    }

    public void setAnyoDebut(int anyoDebut) {
        this.anyoDebut = anyoDebut;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Escuderia{" +
                "idEscuderia=" + idEscuderia +
                ", nombre='" + nombre + '\'' +
                ", Año de debut=" + anyoDebut +
                ", coches=" + coches +
                '}';
    }
}
