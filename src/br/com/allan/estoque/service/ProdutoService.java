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

/*   private void editar(){
                    System.out.println("Digite o nome do Produto que deseja Editar.");
                    String editar = scanner.nextLine();
                    boolean editado = false;


                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).nome.equalsIgnoreCase(editar)) {

                            System.out.println("Produto encontrado.");
                            System.out.println("Qual o novo nome para este produto?");
                            String nomeEdicao = scanner.nextLine();
                            System.out.println("Qual o novo preço para este produto?");
                            double precoEdicao = scanner.nextDouble();
                            scanner.nextLine();

                            Produto p = produtos.get(i);

                            p.setNome(nomeEdicao);
                            p.setPreco(precoEdicao);

                            System.out.println("Produtos atualizado:");
                            System.out.println("Novo nome: " + nomeEdicao);
                            System.out.println("Novo preço " + precoEdicao);
                            editado = true;
                            break;
                        }

                    }
                    if (!editado){
                        System.out.println("Produto não encontrado/editado.");
                    }
                }*/

