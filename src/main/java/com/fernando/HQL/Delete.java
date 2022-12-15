package com.fernando.HQL;

import com.fernando.Herencia.Vehiculo;
import com.fernando.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Delete {
    public static void main(String[] args) {
        //EJEMPLO DE ELIMINACIÓN DE UN REGISTRO
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();
        //ESCOGEMOS EL ÚNICO VEHÍCULO QUE NO ES DE COMPETICIÓN, EN ESTE CASO EL MONOVOLUMEN CREADO ANTERIORMENTE
        Query<Vehiculo>q= ss.createQuery("from Vehiculo V where V.cv < 800");
        Vehiculo v = (Vehiculo)q.uniqueResult();
        ss.remove(v);
        System.out.println("¡Vehículo eliminado!");
        trans.commit();
        ss.close();
    }
}
