package org.example.service;

import org.example.model.Cliente;
import org.example.view.ViewCliente;
import org.example.view.ViewGeral;

public class ClienteService {
    public void gerenciadorCliente(){
        int opcao = ViewCliente.menuCliente();

        switch (opcao){
            case 1->{
                ViewCliente.cadastrarCliente();
            }
            case 2->{
                ViewCliente.listarClientes();
            }
            case 3->{
                ViewCliente.buscarCliente();
            }
            case 4-> {
                ViewCliente.excluirCliente();
            }
            case 0->{
                ViewGeral.menuGeral();
            }

        }
    }
}
