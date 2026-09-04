package br.com.allan.estoque;

import java.util.Scanner;

import br.com.allan.estoque.model.Produto;
import br.com.allan.estoque.repository.ProdutoRepository;
import br.com.allan.estoque.repository.ProdutoRepositoryMemoria;
import br.com.allan.estoque.repository.ProdutoRepositoryMySQL;
import br.com.allan.estoque.service.ProdutoService;

public class Main {
    public static void main(String[] args) {

        ProdutoRepository pr = new ProdutoRepositoryMySQL();
        ProdutoService ps = new ProdutoService(pr);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n ===== MENU =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Editar Produto");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1: {
                    System.out.println("Digite o nome do Produto.");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o Preço do Produto.");
                    double preco = scanner.nextDouble();
                    ps.cadastrar(nome, preco);
                    break;
                }
                case 2: {
                    ps.listar();
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome do Produto que deseja buscar.");
                    String nome = scanner.nextLine();
                    ps.buscar(nome);
                    break;
                }

                case 4: {
                    System.out.println("Digite o nome do Produto que deseja remover.");
                    String nome = scanner.nextLine();
                    ps.excluir(nome);
                    break;
                }
                case 5: {
                    System.out.println("Digite o nome do Produto que deseja editar.");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o novo nome para o Produto que será editado.");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo preço para o Produto que será editado.");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();
                ps.editar(nome, novoNome, novoPreco);
                break;
                }
                case 6: {
                    System.out.println("Saindo do sistema.até logo!");
                    break;
                }
                default: {
                    System.out.println("opção inválida! Tente novamente.");
                    break;
                }
            }
        } while (opcao != 6);
    }
}