package org.example.view;

import org.example.DAO.ClienteDAO;
import org.example.DAO.MotoristaDAO;
import org.example.model.Motorista;
import org.example.utils.MotoristaUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewMotorista {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner (System.in);

    public static int menuMotorista(){
        System.out.println("========= GERENCIADOR DE MOTORISTA =========\n");

        System.out.println("""
                1- Cadastrar Motorista
                2- Listar Motoristas
                3- Buscar Motorista pelo Nome
                4- Excluir Motorista por ID
                0- Voltar ao Menu Inicial
                Digite sua opção:  
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }

    public static void cadastrarMotorista(){

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

    public static void listarMotoristas(){
        System.out.println("========= LISTA DE MOTORISTAS =========\n");

        List<Motorista>motoristas = new ArrayList<>();

        try{
            var motoristaDao = new MotoristaDAO();
            motoristas = motoristaDao.listarMotoristas();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro no Banco de Dados!");
        }
        MotoristaUtils.exibirMotoristas(motoristas);
    }
    public static void buscarMotorista(){
        System.out.println("========= BUSCAR MOTORISTA =========\n");

        List<Motorista> motoristas = new ArrayList<>();

        System.out.println("Digite o Nome do Motorista: ");
        String nome = scStr.nextLine();

        try {
            var motoristaDao = new MotoristaDAO();
            motoristas = motoristaDao.buscarMotorista(nome);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro no Banco de Dados!");
        }
        MotoristaUtils.exibirMotoristas(motoristas);

    }

    public static void excluirMotorista(){
        System.out.println("========= EXCLUIR MOTORISTA =========\n");

        System.out.println("MOTORISTAS DISPONÍVEIS: ");

        List<Motorista>motoristas = new ArrayList<>();

        try {
            var motoristaDao = new MotoristaDAO();
            motoristas = motoristaDao.listarMotoristas();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro no Banco de Dados!");
        }
        MotoristaUtils.exibirMotoristas(motoristas);

        System.out.println("\nDigite o ID do Motorista que deseja excluir: ");
        int id = scNum.nextInt();


        System.out.println("Você tem certeza que deseja excluir o Motorista de ID " + id + " ?");
        System.out.println("Caso exclua o Motorista, todos as Entregas vinculados a ele também serão excluídos.");
        System.out.println("Essa operação não poderá ser desfeita.");
        System.out.println("\nDigite (S) para SIM e (N) para NÃO: ");
        String confirma = scStr.nextLine();

        if(!confirma.equalsIgnoreCase("S")){
            System.out.println("Operação Cancelada pelo Usuário.");
            return;
        }
        else {
            try {
                var motoristaDao = new MotoristaDAO();
                motoristaDao.excluirMotorista(id);
                System.out.println("\nMOTORISTA EXCLUÍDO COM SUCESSO!");

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um Erro no Banco de Dados.");
            }
        }
    }

}
