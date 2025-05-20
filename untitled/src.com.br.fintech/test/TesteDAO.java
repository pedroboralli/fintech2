// TesteDAO.java
package test;

import dao.*;
import model.*;
import java.util.List;

public class TesteDAO {
    public static void main(String[] args) {
        // Criar DAOs
       ObjetivoFinanceiroDAO objetivoDAO = new ObjetivoFinanceiroDAO();
        ReceitaDAO receitaDAO = new ReceitaDAO();
        DespesaDAO despesaDAO = new DespesaDAO();

        // Inserir Objetivo Financeiro
        ObjetivoFinanceiro objetivo = new ObjetivoFinanceiro(10000.0, "2025-12-31");
        objetivoDAO.insert(objetivo);

        // Inserir Receitas
        receitaDAO.insert(new Receita(5000.0, "2025-04-01", "Salário", "Trabalho"));
        receitaDAO.insert(new Receita(1200.0, "2025-04-02", "Venda", "Extra"));

        // Inserir Despesas
        despesaDAO.insert(new Despesa(300.0, "2025-04-03", "Mercado", "Alimentação"));
        despesaDAO.insert(new Despesa(150.0, "2025-04-04", "Internet", "Serviços"));

        // Consultar Receitas
        List<Receita> receitas = receitaDAO.getAll();
        System.out.println("\nReceitas cadastradas:");
        for (Receita r : receitas) {
            System.out.println("- " + r.getDescricao() + ": R$" + r.getValor());
        }

        // Consultar Despesas
        List<Despesa> despesas = despesaDAO.getAll();
        System.out.println("\nDespesas cadastradas:");
        for (Despesa d : despesas) {
            System.out.println("- " + d.getDescricao() + ": R$" + d.getValor());
        }

        System.out.println("\nTestes de DAO executados com sucesso!");
    }
}
