package com.fernando.HQL;

import com.fernando.HibernateUtil;
import com.fernando.OneToOne.Piloto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Update {
    public static void main(String[] args) {
        //EJEMPLO DE MODIFICACIÓN DE UN REGISTRO
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction trans = ss.beginTransaction();

        Query<Piloto>q = ss.createQuery("from Piloto P where P.nombre = 'Inventado Pérez'");
        Piloto p = (Piloto)q.uniqueResult();
        //LE DAMOS UN NOMBRE DE VERDAD AL PILOTO
        p.setNombre("Evilasio Pérez");
        System.out.println("¡Nombre modificado con éxito!");
        //AL HABER USADO EL MÉTODO GET NO NECESITAMOS PERSISTIR EL OBJETO, QUE SE ENCUENTRA EN EL ÁREA DE PERSISTENCIA
        trans.commit();
        ss.close();
    }
}
