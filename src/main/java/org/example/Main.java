package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.criarFormaDePagamentoPadrao(1,"a prazo");
        formaDePagamento.criarFormaDePagamentoPadrao(2,"à vista");

        UnidadeDeMedida unidadeDeMedida = new UnidadeDeMedida();
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(1,"cm");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(2,"g");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(3,"mL");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(4,"unidade");


    }
}