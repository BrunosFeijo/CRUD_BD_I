package org.example;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.criarFormaDePagamentoPadrao(1, "a prazo");
        formaDePagamento.criarFormaDePagamentoPadrao(2, "à vista");

        UnidadeDeMedida unidadeDeMedida = new UnidadeDeMedida();
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(1, "cm");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(2, "g");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(3, "mL");
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(4, "unidade");

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        do {
            menu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0 -> System.out.println();
                case 1 ->System.out.println();
                case 2 ->System.out.println();
                case 3 ->System.out.println();
                case 4 ->System.out.println();
                case 5 ->System.out.println();
                case 6 ->System.out.println();
                case 7 ->System.out.println();
                case 8 ->System.out.println();
                default -> System.out.println("Opção Inválida!!");
            }


        } while (opcao != 0);
    }
    public static void menu() {
        System.out.println("--------Menu--------");
        System.out.println("1- Inserir Produto");
        System.out.println("2- Atualizar Produto");
        System.out.println("3- Listar Produtos");
        System.out.println("4- Deletar Produtos");
        System.out.println("5- Inserir Contrato");
        System.out.println("6- Atualizar Contrato");
        System.out.println("7- Listar Contratos");
        System.out.println("8- Deletar Contrato");
        System.out.println("0- Sair");
        System.out.println("--------------------");
        System.out.print("Digite a opção desejada: ");
    }
    
}