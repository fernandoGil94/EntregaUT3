package com.fernando.UniDirecc;

import com.fernando.HibernateUtil;
import com.fernando.OneToMany.Escuderia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppUnidireccional {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        Director d = new Director("Franz Tost",6,null);
        Escuderia e = new Escuderia("AlphaTauri",2016,null);
        //AÑADIMOS LA ESCUDERÍA QUE QUEREMOS ASOCIAR A SU DIRECTOR
        d.setEscuderia(e);
        //PERSISTIMOS DIRECTOR AL SER EL PROPIETARIO DE LA RELACIÓN
        ss.persist(d);
        //GUARDAMOS LOS CAMBIOS Y CERRAMOS SESIÓN
        trans.commit();
        System.out.println("¡Se han añadido los datos correctamente!");
        ss.close();
    }
}
