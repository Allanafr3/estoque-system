package br.com.allan.estoque.service;

import br.com.allan.estoque.model.Produto;
import br.com.allan.estoque.repository.ProdutoRepository;
import java.util.List;

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

    public void listar() {
        System.out.println("Lista de Produtos:");
        List<Produto> produtos = repository.listarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Lista vazia: não existe nenhum produto cadastrado");
        } else {
            for (Produto p : produtos) {
                System.out.println("Produto: " + p.getNome() + "\n" + "Preço: " + p.getPreco());
            }
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

    public void editar(String nome, String novoNome, double novoPreco){
        Produto encontrado = repository.buscarPorNome(nome);
        if (encontrado != null){
            System.out.println("Produto encontrado: " + encontrado.getNome());
            encontrado.setNome(novoNome);
            encontrado.setPreco(novoPreco);

            System.out.println("Produto editado:");
            System.out.println("Nome alterado para: " + novoNome);
            System.out.println("Preço alterado para: " + novoPreco);

        } else {
            System.out.println("Produto não encontrado");
        }



    }
}
