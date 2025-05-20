package dao;

import connection.DBConnection;
import model.Receita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    public void insert(Receita receita) {
        String sql = "INSERT INTO RECEITAS (valor, data, descricao, categoria) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, receita.getValor());
            stmt.setString(2, receita.getData());
            stmt.setString(3, receita.getDescricao());
            stmt.setString(4, receita.getCategoria());
            stmt.executeUpdate();

            System.out.println("Receita inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir receita: " + e.getMessage());
        }
    }

    public List<Receita> getAll() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM RECEITAS";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Receita r = new Receita(
                        rs.getDouble("valor"),
                        rs.getString("data"),
                        rs.getString("descricao"),
                        rs.getString("categoria")
                );
                receitas.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar receitas: " + e.getMessage());
        }

        return receitas;
    }
}
