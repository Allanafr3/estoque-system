package br.com.allan.estoque;

import java.util.Scanner;

import br.com.allan.estoque.repository.ProdutoRepository;
import br.com.allan.estoque.repository.ProdutoRepositoryMemoria;
import br.com.allan.estoque.service.ProdutoService;

public class Main {
    public static void main(String[] args) {

        ProdutoRepositoryMemoria prm = new ProdutoRepositoryMemoria();
        ProdutoService ps = new ProdutoService(prm);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n ===== MENU =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o nome do Produto.");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o Preço do Produto.");
                    double preco = scanner.nextDouble();
                    ps.cadastrar(nome, preco);
                    break;

                case 2:
                    ps.listar();
                    break;

                case 3:
                    System.out.println("Digite o nome do Produto que deseja buscar.");
                    nome = scanner.nextLine();
                    ps.buscar(nome);
                    break;


                case 4:
                    System.out.println("Digite o nome do Produto que deseja remover.");
                    nome = scanner.nextLine();
                    ps.excluir(nome);
                    break;

                case 5:
                    System.out.println("Saindo do sistema.até logo!");
                    break;
                default:
                    System.out.println("opção inválida! Tente novamente.");
                    break;

            }
        } while (opcao != 5);
    }
}