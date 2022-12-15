package com.fernando.OneToOne;

import com.fernando.Herencia.Vehiculo;
import com.fernando.ManyToMany.Mecanico;
import com.fernando.OneToMany.Escuderia;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue(value = "F1")
/*LA CLASE COCHE NO TENDRÁ UNA TABLA PROPIA EN LA BASE DE DATOS, YA QUE UNA ESCUDERÍA
PUEDE TENER VARIOS TIPOS DE VEHÍCULOS, TABLA EN LA QUE SE ALMACENARÁN LOS OBJETOS COCHE*/
public class Coche extends Vehiculo implements Serializable {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "escuderia",referencedColumnName = "idEscuderia")
    private Escuderia escuderia;
    //No indicamos tipo de fetch, ya que por defecto en relación @OneToOne será "EAGER"
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "piloto",referencedColumnName = "idPiloto")
    private Piloto piloto;
    //Tampoco se indica tipo de fetch, pues por defecto en relaciones @ManyToMany será "LAZY"
    @ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "coches")
    private List<Mecanico> mecanicos;
    public Coche() {
    }

    public Coche(int cv, String tipo, Escuderia escuderia, Piloto piloto, List<Mecanico> mecanicos) {
        super(cv, tipo);
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.mecanicos = mecanicos;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    @Override
    public String toString() {
        return "Coche{" +
                " idVehiculo=" +getIdVehiculo()+
                //", escuderia=" + escuderia +
                //", piloto=" + piloto + COMENTAMOS AMBAS LÍNEAS PARA QUE NO SE REFERENCIEN MUTUAMENTE Y PODAMOS EJECUTAR LA CONSULTA1
                ", mecanicos=" + mecanicos +
                '}';
    }
}
