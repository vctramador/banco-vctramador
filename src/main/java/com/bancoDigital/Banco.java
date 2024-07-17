package main.java.com.bancoDigital;

import java.sql.*;

public class Banco {
    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public Banco() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean testarConexao() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar-se ao banco de dados:");
            e.printStackTrace();
            return false;
        }
    }

    public Conta criarConta(String nome, String cpf, String email, String senha) {
        String sql = "INSERT INTO contas (numeroConta, nome, cpf, email, senha, saldo) VALUES (?, ?, ?, ?, ?, 0.0)";
        long numeroConta = System.currentTimeMillis();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            // Debug: Print valores a serem inseridos
            System.out.println("Tentando inserir conta com número: " + numeroConta);

            stmt.setLong(1, numeroConta);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, senha);
            int rowsAffected = stmt.executeUpdate();

            // Debug: Verificar se a conta foi inserida
            if (rowsAffected > 0) {
                System.out.println("Conta criada com sucesso: " + numeroConta);
                return new Conta(nome, cpf, email, senha, numeroConta);
            } else {
                System.out.println("Falha ao criar conta.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conta buscarConta(long numeroConta) {
        String sql = "SELECT * FROM contas WHERE numeroConta = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Conta (
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getLong("numeroConta"),
                    rs.getDouble("saldo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean atualizarSaldo(long numeroConta, double novoSaldo) {
        String sql = "UPDATE contas SET saldo = ? WHERE numeroConta = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoSaldo);
            stmt.setLong(2, numeroConta);
            int rowsAffected = stmt.executeUpdate();

            // Debug: Verificar se a atualização foi feita
            if (rowsAffected > 0) {
                System.out.println("Saldo atualizado para a conta " + numeroConta + ": " + novoSaldo);
                return true;
            } else {
                System.out.println("Falha ao atualizar o saldo para a conta " + numeroConta);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
