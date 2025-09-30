package org.example.view;

import org.example.DAO.EntregaDAO;
import org.example.model.Entrega;
import org.example.utils.EntregaUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewEntrega {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scstr = new Scanner(System.in);

    public static int menuEntrega(){
        System.out.println("""
                ========= GERENCIADOR DE ENTREGAS =========\n
                1 - GERAR ENTREGA (ATRIBUIR A UM MOTORISTA)
                2 - LISTAR TODAS ENTREGAS DE CLIENTE E MOTORISTA
                3 - LISTAR TODAS AS ENTREGAS
                4 - BUSCAR ENTREGA POR ID
                5 - REGISTRAR EVENTO DE ENTREGA
                6 - ATUALIZAR STATUS DE ENTREGA PARA ENTREGUE
                7 - EXCLUIR ENTREGA
                0 - VOLTAR AO MENU PRINCIPAL
                ===========================================
                
                Digite sua opção: 
                """);
        int opcao = scNum.nextInt();

        return opcao;
    }

    public static void gerarEntrega(){
        System.out.println("========= GERANDO ENTREGA =========\n");

        int pedidoId = EntregaUtils.existeIdPedido();
        int motoristaId = EntregaUtils.existeIdMotorista();

        if (pedidoId != -1 && motoristaId != -1) {


            var entregaDAO = new EntregaDAO();

            try {
                entregaDAO.gerarEntrega(pedidoId, motoristaId);
                System.out.println("ENTREGA GERADA COM SUCESSO!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um erro no Banco de Dados!");
            }
        }else {
            System.out.println("ID do Pedido ou do Motorista não encontrado.");
        }
    }

    public static void listarEntregasPorMotoristaECliente() {
        System.out.println("========= LISTANDO ENTREGAS POR MOTORISTA E CLIENTE =========\n");

        var entregaDAO = new EntregaDAO();

        int idCliente = EntregaUtils.existeIdCliente();
        int idMotista = EntregaUtils.existeIdMotorista();

        if (idMotista != -1 && idCliente != -1) {

            try {
                entregaDAO.listarEntregasPorClienteEMotorista(idCliente, idMotista);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um erro no Banco de Dados!");
            }
        } else {
            System.out.println("ID do Motorista ou do Cliente não encontrado.");
        }

    }
        public static void listarTodasEntregas () {
            System.out.println("========= LISTA DE TODAS AS ENTREGAS =========\n");

            List<Entrega>entregas = new ArrayList<>();

            var entregaDAO = new EntregaDAO();

            try {
                entregas = entregaDAO.listarTodasEntregas();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um erro no Banco de Dados!");
            }
            EntregaUtils.exibirEntregas(entregas);
        }
}
