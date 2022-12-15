package com.fernando.UniDirecc;

import com.fernando.OneToMany.Escuderia;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "directores")
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDirector;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "añosDirector")
    private int anyosDirec;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "escuderia",referencedColumnName = "idEscuderia")
    private Escuderia escuderia;

    public Director() {
    }

    public Director(String nombre, int anyosDirec, Escuderia escuderia) {
        this.nombre = nombre;
        this.anyosDirec = anyosDirec;
        this.escuderia = escuderia;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyosDirec() {
        return anyosDirec;
    }

    public void setAnyosDirec(int anyosDirec) {
        this.anyosDirec = anyosDirec;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return "Director{" +
                "idDirector=" + idDirector +
                ", nombre='" + nombre + '\'' +
                ", anyosDirec=" + anyosDirec +
                ", escuderia=" + escuderia +
                '}';
    }
}
