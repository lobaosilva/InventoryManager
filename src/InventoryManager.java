import java.util.Scanner;

public class InventoryManager {

    // Array para armazenar os produtos
    private static String[] produtos = new String[100]; // Limite de 100 produtos
    private static int totalProdutos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {

                case 1 -> adicionarProduto(scanner);
                case 2 -> removerProduto(scanner);
                case 3 -> listarProdutos();
                case 4 -> buscarProduto(scanner);
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {

        System.out.println("\n===== Sistema de Controle de Estoque =====");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Listar produtos");
        System.out.println("4. Buscar produto");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProduto(Scanner scanner) {

        if (totalProdutos >= produtos.length) {

            System.out.println("O estoque está cheio. Não é possível adicionar mais produtos.");
            return;
        }

        System.out.print("Digite o nome do produto: ");
        String produto = scanner.nextLine();
        produtos[totalProdutos] = produto;
        totalProdutos++;
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void removerProduto(Scanner scanner) {

        System.out.print("Digite o nome do produto a ser removido: ");
        String produto = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < totalProdutos; i++) {

            if (produtos[i].equalsIgnoreCase(produto)) {

                // Remover o produto, deslocando os elementos
                for (int j = i; j < totalProdutos - 1; j++) {

                    produtos[j] = produtos[j + 1];
                }
                produtos[totalProdutos - 1] = null;
                totalProdutos--;
                encontrado = true;
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }

        if (!encontrado) {

            System.out.println("Produto não encontrado no estoque.");
        }
    }

    private static void listarProdutos() {

        if (totalProdutos == 0) {

            System.out.println("O estoque está vazio.");
            return;
        }

        System.out.println("\nProdutos no estoque:");
        for (int i = 0; i < totalProdutos; i++) {

            System.out.println((i + 1) + ". " + produtos[i]);
        }
    }

    private static void buscarProduto(Scanner scanner) {

        System.out.print("Digite o nome do produto para buscar: ");
        String produto = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < totalProdutos; i++) {

            if (produtos[i].equalsIgnoreCase(produto)) {

                System.out.println("Produto encontrado: " + produtos[i] + " (Posição: " + (i + 1) + ")");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {

            System.out.println("Produto não encontrado no estoque.");
        }
    }
}