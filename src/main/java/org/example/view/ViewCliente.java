package org.example.view;

import org.example.DAO.ClienteDAO;
import org.example.model.Cliente;
import org.example.utils.ClienteUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewCliente {
    static Scanner scStr = new Scanner (System.in);
    static Scanner scNum = new Scanner (System.in);

    public static int menuCliente(){
        System.out.println("========= GERENCIADOR DE CLIENTE =========\n");

        System.out.println("""
                1- Cadastrar Cliente
                2- Listar Clientes
                3- Buscar Cliente pelo Nome
                4- Excluir Cliente por ID
                0- Voltar ao Menu Inicial
                Digite sua opção:
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }


    public static void cadastrarCliente(){
        System.out.println("========= CADASTRO DE CLIENTE =========\n");

        var clienteDao = new ClienteDAO();

            System.out.println("Digite o Nome do cliente: ");
            String nome = scStr.nextLine();

            System.out.println("Digite o CPF ou CNPJ do cliente: ");
            String cpf_cnpj = scStr.nextLine();

            System.out.println("Digite o Endereço do cliente: ");
            String endereco = scStr.nextLine();

            System.out.println("Digite a Cidade do cliente: ");
            String cidade = scStr.nextLine();

            System.out.println("Digite o Estado do cliente (ex: SC) : ");
            String estado = scStr.nextLine();

            var cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);

        try{
            clienteDao.cadastrarCliente(cliente);
            System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nOcorreu um erro no Banco de Dados.");
        }

    }

    public static void listarClientes(){
        System.out.println("========= LISTA DE CLIENTES =========\n");

        List<Cliente> clientes = new ArrayList<>();

        try{
            var clienteDao = new ClienteDAO();
            clientes = clienteDao.listarClientes();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de Dados.");
        }
        ClienteUtils.exibirClientes(clientes);
    }

    public static void buscarCliente(){
        System.out.println("========= BUSCAR CLIENTE =========\n");

        System.out.println("Digite o Nome do Cliente: ");
        String nome = scStr.nextLine();

        List<Cliente> clientes = new ArrayList<>();

        try{
            var clienteDao = new ClienteDAO();
            clientes = clienteDao.buscarCliente(nome);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de Dados.");
        }
        ClienteUtils.exibirClientes(clientes);


    }

    public static void excluirCliente(){
        System.out.println("========= EXCLUIR CLIENTE =========\n");



        List<Cliente>clientes = new ArrayList<>();

        try{
            System.out.println("Digite o nome do cliente que deseja excluir: ");
            String nome = scStr.nextLine();
            var clienteDao = new ClienteDAO();
            clientes = clienteDao.buscarCliente(nome);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de Dados.");
        }
        ClienteUtils.exibirClientes(clientes);

        System.out.println("Digite o ID do Cliente que deseja excluir: ");
        int id = scNum.nextInt();


        System.out.println("Você tem certeza que deseja excluir o Cliente de ID " + id + " ? (S/N)");
        System.out.println("Caso exclua o Cliente, todos os Pedidos vinculados a ele também serão excluídos.");
        System.out.println("Essa operação não poderá ser desfeita.");
        String confirma = scStr.nextLine();

        if(!confirma.equalsIgnoreCase("S")){
            System.out.println("Operação Cancelada pelo Usuário.");
            return;
        }
        else {
            try {
                var clienteDao = new ClienteDAO();
                clienteDao.exculirCliente(id);
                System.out.println("\nCLIENTE EXCLUÍDO COM SUCESSO!");

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um Erro no Banco de Dados.");
            }
        }
    }
}




