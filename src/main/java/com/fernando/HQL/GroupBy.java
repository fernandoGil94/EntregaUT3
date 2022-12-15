package com.fernando.HQL;

import com.fernando.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GroupBy {
    public static void main(String[] args) {
        //EJEMPLO DE CONSULTA DE RESULTADOS AGRUPADOS
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object []> q = ss.createQuery("Select V.cv,count(V.id) from Vehiculo V where V.cv = 1010 group by V.cv ");
        List<Object []> vehiculos = q.list();
        for(Object[] v: vehiculos)
            System.out.println("Hay " +v[1]+ " vehículos con " +v[0]+ " caballos de potencia");
        ss.close();
    }
}
