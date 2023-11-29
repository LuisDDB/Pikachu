/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.gansito.persistence;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author aleja
 */
public class MySQLConnection {
    public static Connection get(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://p3nlmysql165plsk.secureserver.net:3306/gansitodb","gansouser","gans0ott#2023");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost/gansitodb?user=root&password=omarneko62");
        }catch(Exception ex){
            System.err.print("Error: "+ex.getMessage());
        }
        return connection;
    }
}
