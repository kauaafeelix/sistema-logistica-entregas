package org.example.view;

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
}
