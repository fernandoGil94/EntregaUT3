package com.fernando.HQL;

import com.fernando.HibernateUtil;
import com.fernando.OneToMany.Escuderia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UniqueQuery {
    public static void main(String[] args) {
        //EJEMPLO DE CONSULTA QUE DEVUELVE UN ÚNICO RESULTADO
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Query<Escuderia> q = ss.createQuery("from Escuderia E where E.nombre = 'Alpine'", Escuderia.class);
        //AL HABER UN ÚNICO RESULTADO DEVUELTO PODEMOS ALMACENARLO EN UN OBJETO DE LA MISMA CLASE, EN ESTE CASO ESCUDERIA
        Escuderia resultado = (Escuderia)q.uniqueResult();
        System.out.println(resultado);
        ss.close();
    }
}
