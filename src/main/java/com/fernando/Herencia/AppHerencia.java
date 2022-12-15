package com.fernando.Herencia;

import com.fernando.HibernateUtil;
import com.fernando.OneToOne.Coche;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppHerencia {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        //CREAMOS UN EJEMPLO DE VEHÍCULO QUE NO SEA DE COMPETICIÓN COMO EJEMPLO
        Vehiculo v = new Vehiculo(150, "Monovolumen");
        Coche c = new Coche(1010,"Coche",null,null,null);
        Moto m = new Moto(850,"Moto","verde");
        //PERSISTIMOS CADA UNO DE LOS OBJETOS
        ss.persist(v);
        ss.persist(c);
        ss.persist(m);
        //GUARDAMOS LOS CAMBIOS Y CERRAMOS SESIÓN
        trans.commit();
        System.out.println("¡Se han añadido los datos correctamente!");
        ss.close();
    }
}
