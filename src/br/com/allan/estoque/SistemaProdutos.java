import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaProdutos {

             private List<Produto> produtos = new ArrayList<>();
             private Scanner scanner = new Scanner(System.in);

            public void iniciar() {
                int opcao = 0;

                produtos.add(new Produto("Caderno", 15.50));
                produtos.add(new Produto("Caneta", 2));

                while (opcao != 5) {
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

                            System.out.println("Digite o nome do produto:");
                            String nome = scanner.nextLine();
                            System.out.println("Digite o preço do produto:");
                            double preco = scanner.nextDouble();

                            produtos.add(new Produto(nome, preco));
                            System.out.println("Produto cadastrado com sucesso.");
                            break;

                        case 2:
                            if (produtos.isEmpty()){
                                System.out.println("Nenhum produto cadastrado");
                            } else {
                                System.out.println("\n--- LISTA DE PRODUTOS ---");
                                for (int i = 0; i < produtos.size(); i++){
                                    Produto p = produtos.get(i);
                                    System.out.println((i + 1) + ". " + p.nome + " - R$ " + p.preco);
                                } break;
                            }

                        case 3:
                            System.out.println("Digite o nome do produto para buscar: ");
                            String busca = scanner.nextLine();
                            boolean encontrado = false;

                            for (Produto p : produtos){
                                if (p.nome.equalsIgnoreCase(busca)){
                                    System.out.println("Encontrado: " + p.nome + " - RS " + p.preco);
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado){
                                System.out.println("Produto não encontrado.");
                            }
                            break;

                        case 4:
                            System.out.println("Digite o nome do produto para excluir: ");
                            String excluir = scanner.nextLine();
                            boolean removido = false;

                            for (int i = 0; i < produtos.size(); i++){
                                if (produtos.get(i).nome.equalsIgnoreCase(excluir)){
                                    produtos.remove(i);
                                    System.out.println("Produto excluído com sucesso!");
                                    removido = true;
                                    break;
                                }
                            }
                            if (!removido){
                                System.out.println("Produto não encontrado para exclusão");
                            }
                            break;

                        case 5:
                            System.out.println("Saindo do sistema.até logo!");
                            break;
                    default:
                        System.out.println("opção inválida! Tente novamente.");

                }
            }
        }
    }
