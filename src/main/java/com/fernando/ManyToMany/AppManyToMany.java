package com.fernando.ManyToMany;

import com.fernando.HibernateUtil;
import com.fernando.OneToOne.Coche;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppManyToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        List<Coche> coches = new ArrayList<>();
        Coche c1 = new Coche(1100,"coche",null,null,null);
        Coche c2 = new Coche(1100,"coche",null,null,null);
        Coche c3 = new Coche(1100,"coche",null,null,null);
        coches.add(c1); coches.add(c2); coches.add(c3);

        List<Mecanico> mecanicos = new ArrayList<>();
        Mecanico m1 = new Mecanico("John Jones",2000,coches);
        Mecanico m2 = new Mecanico("Jesus Lozano",2500,coches);
        Mecanico m3 = new Mecanico("Jan Petrov",3000,coches);
        mecanicos.add(m1); mecanicos.add(m2); mecanicos.add(m3);
        //AÑADIMOS LOS MECÁNICOS A CADA COCHE
        c1.setMecanicos(mecanicos); c2.setMecanicos(mecanicos); c3.setMecanicos(mecanicos);
        //GUARDAMOS LOS OBJETOS COCHE PARA QUE SE AÑADAN UNA VEZ HAGAMOS COMMIT
        ss.save(c1); ss.save(c2); ss.save(c3);
        //AÑADIMOS EL ARRAY DE COCHES A LOS MÉCANICOS Y LOS PERSISTIMOS
        for(int i=0; i< mecanicos.size(); i++){
            ss.persist(mecanicos.get(i));
        }

        //GUARDAMOS LOS CAMBIOS Y CERRAMOS LA CONEXIÓN
        trans.commit();
        System.out.println("¡Se han añadido los datos correctamente!");
        ss.close();
    }
}
