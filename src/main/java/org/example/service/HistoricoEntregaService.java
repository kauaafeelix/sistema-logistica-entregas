package org.example.service;

import org.example.view.ViewHistoricoEntrega;

public class HistoricoEntregaService {

    int opcao = ViewHistoricoEntrega.RelatorioMenu();

    public void gerenciadorHistoricoEntrega(){
        switch (opcao){
            case 1->{
                ViewHistoricoEntrega.totalEntregasPorMotorista();
            }
            case 2->{
                ViewHistoricoEntrega.clientesMaiorVolumeEntregue();
            }
            case 3->{
                ViewHistoricoEntrega.pedidosPendentesPorEstado();
            }
            case 4->{
            }
            case 0->{
            }
        }
    }

}
