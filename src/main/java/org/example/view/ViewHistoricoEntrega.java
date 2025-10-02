package org.example.view;

import org.example.DAO.HistoricoEntregaDAO;
import org.example.model.HistoricoEntrega;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewHistoricoEntrega {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);

    public static int RelatorioMenu(){

        System.out.print("""
                \n|| ==================== MENU RELATÓRIOS ==================== ||
                || 1 - TOTAL DE ENTREGAS POR MOTORISTA
                || 2 - CLIENTES COM MAIOR VOLUME ENTREGUE
                || 3 - PEDIDOS PENDENTES POR ESTADO
                || 4 - ENTREGAS ATRASADAS POR CIDADE
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = scNum.nextInt();
        return opcao;
}

    public static void totalEntregasPorMotorista(){

        System.out.println("========= TOTAL DE ENTREGAS POR MOTORISTA =========\n");

        var historicoDAO = new HistoricoEntregaDAO();

        try {
            historicoDAO.totalEntregasPorMotorista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
