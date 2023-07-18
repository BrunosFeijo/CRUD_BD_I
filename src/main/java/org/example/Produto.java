package org.example;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float valorUnitario;
    private int idUnidadeMediada;

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
}
