package org.example.service;


import org.example.view.ViewGeral;

public class GeralService {
    public int gerenciadorService(){

        int opcao = ViewGeral.menuGeral();

        switch (opcao){
            case 1-> {
                ClienteService clienteService = new ClienteService();
                clienteService.gerenciadorCliente();
            }
            case 2->{
                MotoristaService motoristaService = new MotoristaService();
                motoristaService.gerenciadorMotorista();
            }
            case 3->{
                PedidoService pedidoService = new PedidoService();
                pedidoService.gerenciadorPedido();
            }
            case 4->{
                EntregaService entregaService = new EntregaService();
                entregaService.gerenciadorEntrega();
            }
            case 5->{

            }
            case 0->{}

        }
        return opcao;
    }
}
