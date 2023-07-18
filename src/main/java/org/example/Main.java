package org.example;

import com.sun.source.tree.IfTree;

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
        unidadeDeMedida.criarUnidadeDeMedidaPadrao(4, "un");

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        do {
            menu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0 -> System.out.println("Programa Finalizado!!");
                case 1 -> {
                    System.out.print("Digite o id do produto");
                    int id = entrada.nextInt();
                    System.out.print("Digite o nome do produto");
                    String nome = entrada.nextLine();
                    System.out.print("Digite a descrição do produto");
                    String descricao = entrada.nextLine();
                    System.out.print("Digite o valor do produto");
                    float valor = entrada.nextFloat();
                    System.out.println("Unidades de medida disponíveis no momento? (kkk)");
                    System.out.println("1- Centímetro (cm)");
                    System.out.println("2- Grama (g)");
                    System.out.println("3- Mililítro (mL)");
                    System.out.println("4- Unidade (un)");
                    System.out.print("Digite uma opção: ");
                    int idUnidadeDeMedida = entrada.nextInt();
                    while(idUnidadeDeMedida <= 0 || idUnidadeDeMedida > 4){
                        System.out.print("Digite uma opção válida: ");
                        idUnidadeDeMedida = entrada.nextInt();
                    }
                    Produto produto = new Produto(id,nome,descricao,valor,idUnidadeDeMedida);

                    produto.inserir();

                }
                case 2 -> {
                    System.out.print("Digite o id do produto que será alterado");
                    int id = entrada.nextInt();
                    System.out.print("Digite o nome do produto");
                    String nome = entrada.nextLine();
                    System.out.print("Digite a descrição do produto");
                    String descricao = entrada.nextLine();
                    System.out.print("Digite o valor do produto");
                    float valor = entrada.nextFloat();
                    System.out.println("Unidades de medida disponíveis no momento? (kkk)");
                    System.out.println("1- Centímetro (cm)");
                    System.out.println("2- Grama (g)");
                    System.out.println("3- Mililítro (mL)");
                    System.out.println("4- Unidade (un)");
                    System.out.print("Digite uma opção: ");
                    int idUnidadeDeMedida = entrada.nextInt();
                    while(idUnidadeDeMedida <= 0 || idUnidadeDeMedida > 4){
                        System.out.print("Digite uma opção válida: ");
                        idUnidadeDeMedida = entrada.nextInt();
                    }
                    Produto produto = new Produto(id,nome,descricao,valor,idUnidadeDeMedida);

                    produto.atualizar();
                }
                case 3 -> {
                    Produto produto = new Produto();
                    produto.selecionar();
                }
                case 4 -> {
                    System.out.print("Digite o Id do produto que deseja deletar: ");
                    int id = entrada.nextInt();

                    Produto produto = new Produto();
                    produto.deletar(id);
                }
                case 5 -> {
                    System.out.print("Digite o id do contrato");
                    int id = entrada.nextInt();
                    System.out.print("Digite a data de emissão do contrato no formato('YYYY-MM-DD')");
                    Date data = Date.valueOf(entrada.nextLine());
                    System.out.print("Digite o tempo de vigência do contrato");
                    int vigencia = entrada.nextInt();
                    System.out.println("Formas de Pagamento disponíveis no momento? (kkk)");
                    System.out.println("1- A prazo");
                    System.out.println("2- Á vista");
                    System.out.print("Digite uma opção: ");
                    int idFormaPagamento = entrada.nextInt();
                    while(idFormaPagamento <= 0 || idFormaPagamento > 2){
                        System.out.print("Digite uma opção válida: ");
                        idFormaPagamento = entrada.nextInt();
                    }
                    Contrato contrato = new Contrato(id,data,vigencia,idFormaPagamento);

                    contrato.inserir();
                }
                case 6 -> {
                    System.out.print("Digite o id do contrato a ser atualizado");
                    int id = entrada.nextInt();
                    System.out.print("Digite a data de emissão do contrato no formato('YYYY-MM-DD')");
                    Date data = Date.valueOf(entrada.nextLine());
                    System.out.print("Digite o tempo de vigência do contrato");
                    int vigencia = entrada.nextInt();
                    System.out.println("Formas de Pagamento disponíveis no momento? (kkk)");
                    System.out.println("1- A prazo");
                    System.out.println("2- Á vista");
                    System.out.print("Digite uma opção: ");
                    int idFormaPagamento = entrada.nextInt();
                    while(idFormaPagamento <= 0 || idFormaPagamento > 2){
                        System.out.print("Digite uma opção válida: ");
                        idFormaPagamento = entrada.nextInt();
                    }
                    Contrato contrato = new Contrato(id,data,vigencia,idFormaPagamento);

                    contrato.atualizar();
                }
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