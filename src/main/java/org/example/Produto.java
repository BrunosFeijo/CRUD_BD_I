package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na inserção do novo produto");
            //throw new RuntimeException(e);
        }
    }

    public void atualizar() {
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("update mydb.tbProduto set Nome = ?, Descricao = ?, ValorUnitario = ?, idUnidadeMedida = ? where id = ?");
            preparedStatement.setString(2, this.nome);
            preparedStatement.setString(3, this.descricao);
            preparedStatement.setFloat(4, this.valorUnitario);
            preparedStatement.setInt(5, this.idUnidadeMediada);
            preparedStatement.setInt(1, this.id);

            preparedStatement.execute();

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na atualização do produto");
            //throw new RuntimeException(e);
        }
    }

    public Produto[] selecionar() {
        List<Produto> lista = new ArrayList();
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from mydb.tbProduto");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Produto produto = new Produto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getFloat(4),
                        resultSet.getInt(5)
                );
                lista.add(produto);
            }

            resultSet.close();
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na lista de produtos");
            //throw new RuntimeException(e);
        }
        return lista.toArray(new Produto[0]);
    }

    public void deletar(int id) {
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from mydb.tbProduto where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao deletar produto");
            //throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-50s | R$ %.2f   | %-10s |",
                id, nome, descricao, valorUnitario,idUnidadeMediada);
    }
}
