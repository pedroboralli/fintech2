package dao;

import model.ObjetivoFinanceiro;
import connection.DBConnection;
import java.sql.*;

public class ObjetivoFinanceiroDAO {
    public void insert(ObjetivoFinanceiro objetivo) {
        String sql = "INSERT INTO OBJETIVOS_FINANCEIROS (meta, dataLimite) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, objetivo.getMeta());
            stmt.setString(2, objetivo.getDataLimite());
            stmt.executeUpdate();
            System.out.println("Objetivo Financeiro inserido com sucesso!");
        } catch (SQLException e) {
            if (e.getMessage().contains("ORA-00001")) {
                System.out.println("Objetivo já cadastrado com os mesmos dados.");
            } else {
                System.out.println("Erro ao inserir objetivo financeiro: " + e.getMessage());
            }
        }
    }
}