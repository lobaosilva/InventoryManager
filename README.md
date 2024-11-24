# 🛠️ Sistema de Controle de Estoque

Um sistema interativo em Java que permite gerenciar produtos em um estoque. Com funcionalidades para adicionar, remover, listar e buscar itens, este projeto é ideal para prática de conceitos básicos de programação orientada a objetos e manipulação de estruturas de dados. 🚀

---

## 📋 Solução do Desafio

### Objetivo
1. Criar uma classe principal chamada `InventoryManager`.
2. Estruturar funcionalidades em métodos:
   - Adicionar produto.
   - Remover produto.
   - Listar produtos.
   - Buscar produtos.
3. Armazenar os produtos em um array ou `ArrayList` (para futuras melhorias).
4. Interagir com o usuário via console por meio de um menu dinâmico.

---

## 📂 Estrutura do Código

O sistema é dividido nas seguintes partes:
- **Menu Principal**: Exibe as opções para o usuário.
- **Métodos Funcionais**: Incluem lógica modular para cada operação.
- **Estrutura de Dados**: Um array fixo para armazenar os produtos (substituível por `ArrayList` futuramente).

---

## 💻 Implementação

### Código Completo

```java
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
```

---

## 🧩 Explicação do Código

### 1️⃣ Estrutura de Dados
- **`String[] produtos`**: Um array fixo para armazenar até 100 produtos.
- **`totalProdutos`**: Um contador para rastrear a quantidade atual de produtos no estoque.

### 2️⃣ Métodos
- **`exibirMenu`**: Exibe as opções disponíveis no sistema.
- **`adicionarProduto`**:
    - Adiciona um novo produto ao array, verificando se há espaço disponível.
- **`removerProduto`**:
    - Localiza o produto pelo nome, remove e reorganiza o array.
- **`listarProdutos`**:
    - Exibe todos os produtos cadastrados.
- **`buscarProduto`**:
    - Localiza um produto específico e exibe sua posição.

### 3️⃣ Menu Interativo
- Implementado com um loop `do-while` que permanece ativo até o usuário escolher a opção de saída.

---

## 📊 Exemplo de Execução

### Entrada:

```plaintext
===== Sistema de Controle de Estoque =====
1. Adicionar produto
2. Remover produto
3. Listar produtos
4. Buscar produto
5. Sair
Escolha uma opção: 1
Digite o nome do produto: Feijão
```

### Saída:

```plaintext
Produto adicionado com sucesso!

===== Sistema de Controle de Estoque =====
1. Adicionar produto
2. Remover produto
3. Listar produtos
4. Buscar produto
5. Sair
Escolha uma opção: 3

Produtos no estoque:
1. Feijão
```

---

## 🌟 Destaques do Projeto

- **Gerenciamento Modular**: Cada funcionalidade é encapsulada em métodos específicos.
- **Interação com o Usuário**: Um menu intuitivo para facilitar o uso.
- **Flexibilidade para Melhorias**: Substitua o array por `ArrayList` para maior eficiência no futuro.

Este sistema básico de estoque é um ótimo exemplo para adicionar ao seu portfólio e demonstra habilidades essenciais em lógica de programação e manipulação de dados. 💼
```
