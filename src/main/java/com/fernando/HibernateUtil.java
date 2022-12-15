package com.fernando;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //CREAMOS EL OBJETO SESSIONFACTORY ESTÁTICO PARA QUE SEA COMÚN A LA CLASE
    private static SessionFactory factory;
    //HACEMOS EL CONSTRUCTOR PRIVADO PARA QUE NO SE PUEDAN CREAR OTRAS INSTANCIAS, SIGUIENEDO EL DISEÑO SINGLETON
    private HibernateUtil(){

    }
    //POR ÚLTIMO CREAMOS EL MÉTODO QUE DEVUELVE EL SESSIONFACTORY SI NO EXISTE PREVIAMENTE
    public static SessionFactory getSessionFactory(){
        if(factory == null){
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return factory;
    }
}
