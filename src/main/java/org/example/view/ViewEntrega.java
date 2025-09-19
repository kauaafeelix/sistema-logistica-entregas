package org.example.view;

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
}
