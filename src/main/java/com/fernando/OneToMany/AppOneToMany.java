package com.fernando.OneToMany;

import com.fernando.HibernateUtil;
import com.fernando.OneToOne.Coche;
import com.fernando.OneToOne.Piloto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AppOneToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        //CREAMOS LAS ESCUDERÍA
        Escuderia e1 = new Escuderia("Ferrari",1950,null);

        //CREAMOS EL ARRAY DE COCHES
        ArrayList<Coche> coches = new ArrayList<>();
        Coche c1 = new Coche(1010,"coche",e1,new Piloto("Charles Leclerc","Monegasca",null),null);
        Coche c2 = new Coche(1060,"coche",e1,new Piloto("Inventado Pérez","Mejicana",null),null);
        Coche c3 = new Coche(1100,"coche",e1,new Piloto("Carlos Sainz Jr.","Española",null),null);

        //AÑADIMOS LOS COCHES AL ARRAY
        coches.add(c1);
        coches.add(c2);
        coches.add(c3);

        //AÑADIMOS A LA ESCUDERÍA LOS COCHES CON SUS PILOTOS
        e1.setCoches(coches);
        //PERSISTIMOS LOS COCHES (PARTE N DE LA RELACIÓN 1-N)
        for(int i=0; i < coches.size(); i++)
            ss.persist(coches.get(i));

        //HACEMOS COMMIT PARA REFLEJAR LOS CAMBIOS EN LA BBDD Y CERRAMOS SESIÓN
        trans.commit();
        System.out.println("¡Se han añadido los datos correctamente!");
        ss.close();
    }
}
