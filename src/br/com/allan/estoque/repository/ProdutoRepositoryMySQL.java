package br.com.allan.estoque.repository;

import br.com.allan.estoque.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMySQL implements ProdutoRepository {

    private Connection conexao = new ConexaoMySQL().obterConexao();

    @Override
    public Produto salvar(Produto produto) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO produtos (nome, preco) VALUES (?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("Falha ao cadastrar produto.");
        }
        return produto;
    }

    @Override
    public List<Produto> listarTodos() {
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produtos");
            List<Produto> produtos = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String nomeDB = rs.getString("nome");
                Double precoDB = rs.getDouble(("preco"));

                Produto p = new Produto (nomeDB, precoDB);
                produtos.add(p);
            }
            return produtos;
        } catch (SQLException e) {
            System.out.println("Falha ao listar produtos.");
        }
        return null;
    }

    @Override
    public Produto buscarPorNome(String nome) {
        try{
           PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome = ?");
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           rs.next();
           String nomeDB = rs.getString("nome");
           Double precoDB =rs.getDouble("preco");

           Produto p = new Produto(nomeDB, precoDB);

           return p;

        } catch (SQLException e){
            System.out.println("Falha ao buscar produto por nome.");
        }
        return null;
    }

    @Override
    public boolean excluir(String nome) {
       try {
       PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produtos WHERE nome = ?");
       stmt.setString(1, nome);
       stmt.executeUpdate();

       return true;

       } catch (SQLException e){
           System.out.println("Falha ao excluir produto.");
       }
        return false;
    }
}
