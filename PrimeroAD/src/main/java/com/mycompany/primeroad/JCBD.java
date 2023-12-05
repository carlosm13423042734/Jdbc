package com.mycompany.primeroad;
//Boton 
import java.sql.*;

public class JCBD {
    //Ponemos los datos de la base de datos
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "DAM";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String args[]) {
        //Nos conectamos a la base de datos creamos el Statement y ejecutamos la consulta
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);){
            //Esto imprimirá todos los datos de los videojuegos que existan
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));          
            }
            //Por último cerramos la conexión y tratamos excepciones
            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
