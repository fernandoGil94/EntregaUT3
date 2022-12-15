package com.fernando.HQL;

import com.fernando.HibernateUtil;
import com.fernando.OneToOne.Piloto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        //CREAMOS EL OBJETO QUERY QUE ALMACENARÁ CADA UNO DE LOS OBJETOS RESULTANTES DE LA CONSULTA
        Query<Piloto> q = ss.createQuery("from Piloto", Piloto.class);
        List<Piloto> pilotos = q.list();
        for(Piloto a: pilotos)
            System.out.println(a);
        ss.close();
    }
}
