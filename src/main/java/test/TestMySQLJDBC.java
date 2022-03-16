package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySQLJDBC {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "AlfredoRiosS98", "Rios_12");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id Persona" + resultado.getInt("id_persona"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
