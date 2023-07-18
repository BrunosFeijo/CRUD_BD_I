package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPadrao {
    public static Connection conector(){
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String usuario = "root";
        String senha = "Thais2507*";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            return conexao;
        }catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
