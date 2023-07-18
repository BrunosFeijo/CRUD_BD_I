package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormaDePagamento {
    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void criarFormaDePagamentoPadrao(int id, String descricao){
        this.id = id;
        this.descricao = descricao;


        Connection conexao = ConexaoPadrao.conector();
        String sql = "SELECT COUNT(*) FROM tbFormaPagamento WHERE id = ?";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, getId());
            try (ResultSet resultado = pst.executeQuery()) {
                resultado.next();
                int count = resultado.getInt(1);
                if(count == 0){
                    sql = "INSERT INTO tbFormaPagamento (id,Descricao) VALUES (?,?)";

                    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                        stmt.setInt(1, getId());
                        stmt.setString(2, getDescricao());
                        stmt.execute();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


}
