package org.example;

import java.sql.*;

public class Contrato {
    private int id;
    private Date dataEmissao;
    private int tempoVigencia;
    private int idFormaDePagamento;
    private Produto[] produtos;
    private int[] quantidades;

    public Contrato() {

    }

    public Contrato(int id, Date dataEmissao, int tempoVigencia, int idFormaDePagamento) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.tempoVigencia = tempoVigencia;
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getTempoVigencia() {
        return tempoVigencia;
    }

    public void setTempoVigencia(int tempoVigencia) {
        this.tempoVigencia = tempoVigencia;
    }

    public int getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(int idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public int[] getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(Integer[] quantidades) {
        int[] array = new int[quantidades.length];
        for (int i = 0; i < quantidades.length; i++) {
            array[i] = quantidades[i];
        }
        this.quantidades = array;
    }

    public void inserir() {
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("insert into mydb.tbContrato (idContrato,DataEmissao,TempoVigencia,idFormaPagamento) value (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, dataEmissao);
            preparedStatement.setInt(3, tempoVigencia);
            preparedStatement.setInt(4, idFormaDePagamento);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
            for (int i = 0; i < this.produtos.length; i++) {
                preparedStatement = conexao.prepareStatement("insert into mydb.tbContrato_has_tbProduto (idContrato,idProduto,Quantidade) values (?,?,?)");
                preparedStatement.setInt(1,id);
                preparedStatement.setInt(2, produtos[i].getId());
                preparedStatement.setInt(3, quantidades[i]);

                preparedStatement.execute();
            }

            resultSet.close();
            preparedStatement.close();
            conexao.close();
            System.out.println("Operação executada com sucesso");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao deletar produto");
            //throw new RuntimeException(e);
        }
    }

    public void atualizar() {
        try {
            Connection conexao = ConexaoPadrao.conector();
            PreparedStatement preparedStatement = conexao.prepareStatement("update mydb.tbContrato set DataEmissao = ?,TempoVigencia = ? ,idFormaPagamento = ? where idContrato = ?");

            preparedStatement.setDate(1, dataEmissao);
            preparedStatement.setInt(2, tempoVigencia);
            preparedStatement.setInt(3, idFormaDePagamento);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

            preparedStatement.close();
            conexao.close();
            System.out.println("Operação executada com sucesso");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao deletar produto");
            //throw new RuntimeException(e);
        }
    }

    public void selecionar() {

    }

    public void deletar(int id) {

    }
}
