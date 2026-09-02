package br.com.allan.estoque.repository;

import br.com.allan.estoque.model.Produto;
import java.util.List;
import java.util.ArrayList;

public class ProdutoRepositoryMemoria implements ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public Produto salvar(Produto produto) {
        produtos.add(produto);
        return produto;

    }

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

    @Override
    public Produto buscarPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Produto editar(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                return produtos.get(i);
            }
        }
        return null;
    }
}