package org.example.view;

import org.example.DAO.MotoristaDAO;
import org.example.model.Motorista;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewMotorista {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner (System.in);

    public static int menuMotorista(){
        System.out.println("========= GERENCIADOR DE MOTORISTA =========\n");

        System.out.println("""
                1- Cadastrar Motorista\n
                2- Listar Todas as Entregas\n
                3- Total de Entregas por Motorista\n
                4- Excluir Motorista\n
                0- Voltar ao Menu Inicial\n
                Digite sua opção:\n  
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }

    public void cadastrarMotorista(){

        System.out.println("========= CADASTRO DE MOTORISTA =========\n");

        System.out.println("Digite o Nome do motorista: ");
        String nome = scStr.nextLine();

        System.out.println("Digite o número da CNH do motorista: ");
        String cnh = scStr.nextLine();

        System.out.println("Digite a placa do Veículo do motorista: ");
        String placaVeiculo = scStr.nextLine();

        System.out.println("Digite a Cidade base do motorista");
        String cidade_base = scStr.nextLine();

        Motorista motorista = new Motorista(nome, cnh, placaVeiculo, cidade_base);

        var motoristaDao = new MotoristaDAO();

        try{
            motoristaDao.cadastrarMotorista(motorista);
            System.out.println("\nMOTORISTA CADASTRADO COM SUCESSO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro no Banco de Dados!");
        }

    }
}
