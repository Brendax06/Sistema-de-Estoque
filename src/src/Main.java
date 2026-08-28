import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    listarProdutos();
                    break;

                case 3:
                    buscarProduto();
                    break;

                case 4:
                    entradaEstoque();
                    break;

                case 5:
                    saidaEstoque();
                    break;

                case 6:
                    produtosEstoqueBaixo();
                    break;

                case 7:
                    valorTotalEstoque();
                    break;

                case 8:
                    excluirProduto();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado!");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {

        System.out.println("\n==================================");
        System.out.println("       SISTEMA DE ESTOQUE");
        System.out.println("==================================");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Buscar produto");
        System.out.println("4 - Entrada de estoque");
        System.out.println("5 - Saída de estoque");
        System.out.println("6 - Produtos com estoque baixo");
        System.out.println("7 - Valor total do estoque");
        System.out.println("8 - Excluir produto");
        System.out.println("0 - Sair");
        System.out.println("==================================");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarProduto() {

        System.out.println("\n--- CADASTRO DE PRODUTO ---");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: R$ ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Estoque mínimo: ");
        int estoqueMinimo = scanner.nextInt();

        Produto produto = new Produto(
                id,
                nome,
                preco,
                quantidade,
                estoqueMinimo
        );

        produtos.add(produto);

        System.out.println("\nProduto cadastrado com sucesso!");
    }

    public static void listarProdutos() {

        System.out.println("\n--- PRODUTOS CADASTRADOS ---");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public static void buscarProduto() {

        System.out.print("\nDigite o ID do produto: ");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                System.out.println("\nProduto encontrado:");
                System.out.println(produto);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void entradaEstoque() {

        System.out.print("\nDigite o ID do produto: ");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {

            if (produto.getId() == id) {

                System.out.print("Quantidade de entrada: ");
                int quantidade = scanner.nextInt();

                produto.entradaEstoque(quantidade);

                System.out.println("Entrada registrada!");
                System.out.println("Novo estoque: " + produto.getQuantidade());

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void saidaEstoque() {

        System.out.print("\nDigite o ID do produto: ");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {

            if (produto.getId() == id) {

                System.out.print("Quantidade de saída: ");
                int quantidade = scanner.nextInt();

                if (produto.saidaEstoque(quantidade)) {
                    System.out.println("Saída registrada!");
                    System.out.println(
                            "Novo estoque: " + produto.getQuantidade()
                    );
                } else {
                    System.out.println(
                            "Erro: quantidade insuficiente em estoque."
                    );
                }

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void produtosEstoqueBaixo() {

        System.out.println("\n--- ESTOQUE BAIXO ---");

        boolean encontrou = false;

        for (Produto produto : produtos) {

            if (produto.estoqueBaixo()) {
                System.out.println(produto);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

    public static void valorTotalEstoque() {

        double total = 0;

        for (Produto produto : produtos) {
            total += produto.calcularValorEstoque();
        }

        System.out.printf(
                "\nValor total do estoque: R$ %.2f%n",
                total
        );
    }

    public static void excluirProduto() {

        System.out.print("\nDigite o ID do produto: ");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {

            if (produto.getId() == id) {

                produtos.remove(produto);

                System.out.println(
                        "Produto excluído com sucesso!"
                );

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}
