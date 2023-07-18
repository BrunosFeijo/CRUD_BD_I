package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        conexao = ConexaoPadrao.conector();
        System.out.println(conexao);

    }
}