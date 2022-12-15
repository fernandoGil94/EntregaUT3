package com.fernando.ManyToMany;

import com.fernando.OneToOne.Coche;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue(value = "especialidad")
public class Mecanico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMecanico;
    @Column(name = "nombre")
    private String nom;
    @Column(name = "salario")
    private double salario;
    @ManyToMany
    @JoinTable(name = "Mecanico_Coche",
        joinColumns = {@JoinColumn(name = "FK_Mecanico",referencedColumnName = "idMecanico")},
        inverseJoinColumns = {@JoinColumn(name = "FK_Coche",referencedColumnName = "idVehiculo")})
    private List<Coche> coches;

    public Mecanico() {
    }

    public Mecanico(String nom, double salario, List<Coche> coches) {
        this.nom = nom;
        this.salario = salario;
        this.coches = coches;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "idMecanico=" + idMecanico +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", coches=" + coches +
                '}';
    }
}
