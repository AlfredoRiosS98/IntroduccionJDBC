package test;

import java.sql.*;

public class TestMySQLJDBC {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "AlfredoRiosS98", "Rios_12");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_personas, nombre, apellido, email, telefono FROM personas";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id Persona" + resultado.getInt("id_personas"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
