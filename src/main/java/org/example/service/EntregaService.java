package org.example.service;

import org.example.view.ViewEntrega;

public class EntregaService {
    public void gerenciadorEntrega(){
        int opcao = ViewEntrega.menuEntrega();

        switch (opcao){
            case 1->{
                ViewEntrega.gerarEntrega();
            }
            case 2->{
                ViewEntrega.listarEntregasPorMotoristaECliente();
            }
            case 3->{
                ViewEntrega.listarTodasEntregas();
            }
            case 4->{}
            case 5->{}
            case 6->{}
            case 0->{}
        }
    }
}
