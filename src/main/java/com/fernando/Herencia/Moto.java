package com.fernando.Herencia;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "GP")
/*LA CLASE MOTO NO TENDRÁ UNA TABLA PROPIA EN LA BASE DE DATOS, YA QUE UNA ESCUDERÍA
PUEDE TENER VARIOS TIPOS DE VEHÍCULOS, TABLA EN LA QUE SE ALMACENARÁN LOS OBJETOS MOTO*/
public class Moto extends Vehiculo{
    @Column(name = "color")
    private String color;

    public Moto() {
    }

    public Moto(int cv, String tipo, String color) {
        super(cv, tipo);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Moto{" +
                " idVehiculo= " + getIdVehiculo()+
                ", cv= " +getCv()+
                ", color= '" + color + '\'' +
                '}';
    }
}
