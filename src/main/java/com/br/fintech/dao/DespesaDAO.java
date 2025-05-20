package dao;

import connection.DBConnection;
import model.Despesa;
import model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    public void insert(Despesa despesa) {
        String sql = "INSERT INTO DESPESAS (valor, data, descricao, categoria) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, despesa.getValor());
            stmt.setString(2, despesa.getData());
            stmt.setString(3, despesa.getDescricao());
            stmt.setString(4, despesa.getCategoria());
            stmt.executeUpdate();

            System.out.println("Despesa inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir despesa: " + e.getMessage());
        }
    }

    public List<Despesa> getAll() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM DESPESAS";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Despesa d = new Despesa(
                        rs.getDouble("valor"),
                        rs.getString("data"),
                        rs.getString("descricao"),
                        rs.getString("categoria")
                );
                despesas.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar despesas: " + e.getMessage());
        }

        return despesas;
    }
}
