package dao;

import connection.DBConnection;
import model.Login;
import java.sql.*;

public class LoginDAO {

    public void insert(Login login) {
        String sql = "INSERT INTO LOGIN (usuario, senha) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getSenha());
            stmt.executeUpdate();

            System.out.println("Login inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir login: " + e.getMessage());
        }
    }

    public Login getByUsuario(String usuario) {
        String sql = "SELECT * FROM LOGIN WHERE usuario = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Login(
                        rs.getString("usuario"),
                        rs.getString("senha")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar login: " + e.getMessage());
        }
        return null;
    }
}
