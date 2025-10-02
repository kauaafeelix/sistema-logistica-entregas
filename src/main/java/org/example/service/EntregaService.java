package org.example.service;

import org.example.view.ViewEntrega;
import org.example.view.ViewGeral;

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
            case 4->{
                ViewEntrega.buscarEntregaPorId();
            }
            case 5->{
                ViewEntrega.registrarEventoDeEntrega();
            }
            case 6->{
                ViewEntrega.excluirEntega();
            }
            case 0->{
                ViewGeral.menuGeral();
            }
        }
    }
}
