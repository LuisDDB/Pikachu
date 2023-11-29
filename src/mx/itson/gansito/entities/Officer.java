/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.gansito.entities;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mx.itson.gansito.persistence.MySQLConnection;
import java.sql.ResultSet;

/**
 *
 * @author aleja
 */
public class Officer {

    private int id;
    private String name;
    private String phone;

    public static List<Officer> getAll(String filtro) {
        List<Officer> officers = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM officer WHERE name LIKE ?");
            statement.setString(1, "%" + filtro + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Officer o = new Officer();
                o.setId(resultSet.getInt(1));
                o.setName(resultSet.getString(2));
                o.setPhone(resultSet.getString(3));
                officers.add(o);
            }
        } catch (SQLException ex) {

        }
        return officers;
    }

    public static boolean save(String nombre, String telefono) {
        boolean result = false;

        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO officer (name,phone) VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, telefono );
            statement.execute();
            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return result;
    }
    public static boolean update(String nombre, String telefono, int id) {
        boolean result = false;

        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE officer SET name= ?, phone=? WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,  nombre );
            statement.setString(2, telefono );
            statement.setInt(3, id );
            statement.execute();
            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return result;
    }
    public static boolean delete (int id) {
        boolean result = false;

        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE from officer WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id );
            statement.execute();
            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
