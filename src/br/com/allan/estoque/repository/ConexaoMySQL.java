package br.com.allan.estoque.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    public Connection obterConexao() {
        String url = "jdbc:mysql://localhost:3306/estoque";
        String usuario = "root";
        String senha = "12345678";
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Conexão falhou.");
        }
        return null;
    }
}


