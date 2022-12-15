/*Ejecutar para crear la base de datos*/
package com.fernando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDatabase {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement stmt = null;

        try{
            System.out.println("Generando nueva base de datos..");

            conexion = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","root","root");
            stmt = conexion.createStatement();
            String sql = "CREATE DATABASE fernando;";
            stmt.execute(sql);
            System.out.println("¡Base de datos creada con éxito!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

