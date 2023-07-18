package org.example;

import java.sql.Date;

public class Contrato {
    private int id;
    private Date dataEmissao;
    private int tempoVigencia;
    private int idFormaDePagamento;
    private int[] idProduto;

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

    public int[] getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int[] idProduto) {
        this.idProduto = idProduto;
    }
}
