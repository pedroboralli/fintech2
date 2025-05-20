package model;

public class Receita extends Transacao {
    public Receita(double valor, String data, String descricao, String categoria){
        super(valor, data, descricao, categoria);
    }

    public Receita(String salário, double v) {
        super(salário, v);
    }

    @Override
    public double getValorOperacao() {
        return getValor(); // Receita retorna valor positivo
    }
}