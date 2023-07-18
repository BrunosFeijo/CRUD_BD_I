package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float valorUnitario;
    private int idUnidadeMediada;

    public Produto() {

    }

    public Produto(int id, String nome, String descricao, float valorUnitario, int idUnidadeMediada) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.idUnidadeMediada = idUnidadeMediada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getIdUnidadeMediada() {
        return idUnidadeMediada;
    }

    public void setIdUnidadeMediada(int idUnidadeMediada) {
        this.idUnidadeMediada = idUnidadeMediada;
    }

    public void inserir() {
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("insert into mydb.tbProduto (idProduto, Nome, Descricao, ValorUnitario, idUnidadeMedida) values (?,?,?,?,?)");
            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.nome);
            preparedStatement.setString(3, this.descricao);
            preparedStatement.setFloat(4, this.valorUnitario);
            preparedStatement.setInt(5, this.idUnidadeMediada);

            preparedStatement.execute();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na inserção do novo produto");
            //throw new RuntimeException(e);
        }
    }

    public void atualizar() {
        
    }

    public void selecionar() {

    }

    public void deletar(int id) {

    }
}
