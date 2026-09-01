package br.com.allan.estoque.service;

import br.com.allan.estoque.model.Produto;
import br.com.allan.estoque.repository.ProdutoRepository;

public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public void cadastrar(String nome, double preco){
       Produto p = new Produto(nome, preco);
       repository.salvar(p);
       System.out.println("Produto cadastrado com sucesso.");
    }

    public void listar(){
        System.out.println("Lista de Produtos:");
        for (Produto p : repository.listarTodos()) {
            System.out.println("Produto: " + p.getNome() + "\n" + "Preço: " + p.getPreco() );
        }
    }

    public void buscar(String nome){
        Produto encontrado = repository.buscarPorNome(nome);
        if (encontrado != null){
            System.out.println("Produto Encontrado");
            System.out.println("Produto: " + encontrado.getNome() + " " + "Preço: " + encontrado.getPreco());
            } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void excluir(String nome){
        boolean removido = repository.excluir(nome);
        if (removido){
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Falha, o produto não foi removido");
        }
    }
}



