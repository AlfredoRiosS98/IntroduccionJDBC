package test;

import java.sql.*;

public class TestMySQLJDBC {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "nameUser", "password");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_personas, nombre, apellido, email, telefono FROM personas";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id Persona" + resultado.getInt("id_personas"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
