package com.fernando.OneToOne;

import com.fernando.HibernateUtil;
import com.fernando.OneToMany.Escuderia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppOneToOne {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        Coche c1 = new Coche(1000,"coche",new Escuderia("Mercedes-AMG",1954,null),null,null);
        Coche c2 = new Coche(1050,"coche",new Escuderia("Alpine",2021,null),null,null);
        Coche c3 = new Coche(1020,"coche",new Escuderia("Red Bull",1995,null),null,null);

        Piloto p1 = new Piloto("Lewis Hamilton","Inglesa",c1);
        Piloto p2 = new Piloto("Fernando Alonso","Española",c2);
        Piloto p3 = new Piloto("Max Verstappen","Holandesa",c3);
        //INCLUIMOS A LOS COCHES LOS DATOS DE SUS PILOTOS PARA PERSISTIRLOS, AL SER COCHE EL PROPIETARIO DE LA RELACIÓN
        c1.setPiloto(p1);
        c2.setPiloto(p2);
        c3.setPiloto(p3);

        //PERSISTIMOS LOS OBJETOS
        ss.persist(c1);
        ss.persist(c2);
        ss.persist(c3);
        //HACEMOS COMMIT PARA QUE SE REFLEJEN LOS CAMBIOS EN LA BASE DE DATOS
        trans.commit();
        System.out.println("¡Se han añadido los datos correctamente!");
        //CERRAMOS LA SESIÓN
        ss.close();
    }
}
