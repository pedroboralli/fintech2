package model;

public class ObjetivoFinanceiro {
    private double meta;
    private String dataLimite;

    public ObjetivoFinanceiro(double meta, String dataLimite){
        this.meta = meta;
        this.dataLimite = dataLimite;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public boolean atingiuMeta(double saldo) {
        return saldo >= meta;
    }
}