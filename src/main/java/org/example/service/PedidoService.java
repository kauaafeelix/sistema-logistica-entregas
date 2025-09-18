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
            case 2->{}
            case 3->{}
            case 4->{}
            case 0->{}


        }
    }
}
