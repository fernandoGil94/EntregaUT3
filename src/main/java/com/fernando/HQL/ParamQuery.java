package com.fernando.HQL;

import com.fernando.Herencia.Vehiculo;
import com.fernando.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ParamQuery {
    public static void main(String[] args) {
        //EJEMPLO DE CONSULTA HACIENDO USO DE UN PARÁMETRO DE ENTRADA Y LA CLÁUSULA WHERE
        int caballos = 850;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Vehiculo> q = ss.createQuery("from Vehiculo v where v.cv = :cv");
        q.setParameter("cv",caballos);
        Vehiculo result = (Vehiculo)q.uniqueResult();
        System.out.println(result);
    }
}
