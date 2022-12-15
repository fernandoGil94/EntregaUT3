package com.fernando.HQL;

import com.fernando.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SelectQuery {
    public static void main(String[] args) {
        //EJEMPLO DE QUERY HACIENDO USO DE LAS CLÁUSULAS SELECT Y ORDER BY
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        //CONSULTA QUE DEVUELVE EL NOMBRE DE LOS PILOTOS EN ORDEN DESCENDENTE
        Query<String[]> q2 = ss.createQuery("SELECT P.nombre FROM Piloto P ORDER BY P.nombre desc");
        List<String[]> nombres = q2.list();
        for(int i=0; i< nombres.size(); i++){
            System.out.println(nombres.get(i));
        }
        ss.close();
    }
}
