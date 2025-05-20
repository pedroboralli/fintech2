package model;

public class Despesa extends Transacao {
    public Despesa(double valor, String data, String descricao, String categoria){
        super(valor, data, descricao, categoria);
    }

    @Override
    public double getValorOperacao() {
        return -getValor(); // Despesa retorna valor negativo
    }
}
