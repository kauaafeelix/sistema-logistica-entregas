package org.example.service;

import org.example.view.ViewGeral;
import org.example.view.ViewPedido;

public class PedidoService {
    public void gerenciadorPedido(){
        int opcao = ViewPedido.menuPedido();

        switch (opcao){
            case 1->{
                ViewPedido.criarPedido();
            }
            case 2->{
                ViewPedido.listarPedidos();
            }
            case 3->{
                ViewPedido.buscarPedido();
            }
            case 4->{
                ViewPedido.atualizarPedido();
            }
            case 5->{
                ViewPedido.cancelarPedido();
            }
            case 6->{
                ViewPedido.excluirPedido();
            }
            case 0->{
                ViewGeral.menuGeral();
            }


        }
    }
}
