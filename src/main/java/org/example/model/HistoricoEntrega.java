package org.example.model;

public class HistoricoEntrega {
    private int id;
    private int entrega_id;
    private String data_evento;
    private String descricao;

    public HistoricoEntrega(int id, int entrega_id, String data_evento, String descricao) {
        this.id = id;
        this.entrega_id = entrega_id;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    public HistoricoEntrega(int entrega_id, String data_evento, String descricao) {
        this.entrega_id = entrega_id;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntrega_id() {
        return entrega_id;
    }

    public void setEntrega_id(int entrega_id) {
        this.entrega_id = entrega_id;
    }

    public String getData_evento() {
        return data_evento;
    }

    public void setData_evento(String data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
