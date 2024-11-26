package mercado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Caixa caixa = new Caixa();
        GestorProdutos gestorProdutos = new GestorProdutos();
        GestorRelatorios gestorRelatorios = new GestorRelatorios();

        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("\n=== Sistema de Gerenciamento do Mercado ===");
            System.out.println("1. Abrir Caixa");
            System.out.println("2. Fechar Caixa");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Iniciar Nova Venda");
            System.out.println("6. Gerar Relatório de Produtos a Vencer");
            System.out.println("7. Gerar Relatório de Produtos com Baixo Estoque");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado.

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor inicial do caixa: R$ ");
                    double valorInicial = scanner.nextDouble();
                    caixa.abrirCaixa(valorInicial);
                    break;

                case 2:
                    caixa.fecharCaixa();
                    break;

                case 3:
                    System.out.println("=== Cadastro de Produto ===");
                    System.out.print("Tipo (1: Alimento/Utensílio, 2: Eletroeletrônico): ");
                    int tipoProduto = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado.

                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço por unidade: R$ ");
                    double preco = scanner.nextDouble();

                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();

                    if (tipoProduto == 1) {
                        System.out.print("Validade (em dias): ");
                        int validade = scanner.nextInt();
                        gestorProdutos.cadastrarProduto(new AlimentoUtensilio(codigo, nome, preco, quantidade, validade));
                    } else if (tipoProduto == 2) {
                        System.out.print("Garantia (em meses): ");
                        int garantia = scanner.nextInt();
                        gestorProdutos.cadastrarProduto(new Eletroeletronico(codigo, nome, preco, quantidade, garantia));
                    } else {
                        System.out.println("Tipo inválido!");
                    }
                    break;

                case 4:
                    System.out.println("=== Lista de Produtos ===");
                    gestorProdutos.listarProdutos();
                    break;

                case 5:
                    System.out.println("=== Nova Venda ===");
                    Venda venda = new Venda();
                    boolean vendendo = true;
                    while (vendendo) {
                        System.out.println("1. Adicionar Produto");
                        System.out.println("2. Remover Produto");
                        System.out.println("3. Finalizar Venda");
                        System.out.print("Escolha uma opção: ");
                        int opcaoVenda = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer.

                        switch (opcaoVenda) {
                            case 1:
                                System.out.print("Informe o código do produto: ");
                                String codigoVenda = scanner.nextLine();

                                Produto produtoVenda = gestorProdutos.buscarProdutoPorCodigo(codigoVenda);
                                if (produtoVenda == null) {
                                    System.out.println("Produto não encontrado.");
                                    break;
                                }

                                System.out.print("Quantidade: ");
                                int quantidadeVenda = scanner.nextInt();
                                venda.adicionarProduto(produtoVenda, quantidadeVenda);
                                break;

                            case 2:
                                System.out.print("Informe o código do produto: ");
                                String codigoRemocao = scanner.nextLine();

                                Produto produtoRemocao = gestorProdutos.buscarProdutoPorCodigo(codigoRemocao);
                                if (produtoRemocao == null) {
                                    System.out.println("Produto não encontrado.");
                                    break;
                                }
                                venda.removerProduto(produtoRemocao);
                                break;

                            case 3:
                                venda.finalizarVenda();
                                caixa.registrarVenda(venda.calcularSubtotal());
                                vendendo = false;
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Informe o número de dias para verificar produtos a vencer: ");
                    int dias = scanner.nextInt();
                    gestorRelatorios.gerarRelatorioVencimento(gestorProdutos.getProdutosAlimentos(), dias);
                    break;

                case 7:
                    System.out.print("Informe a quantidade mínima para o relatório: ");
                    int quantidadeMinima = scanner.nextInt();
                    gestorRelatorios.gerarRelatorioBaixaQuantidade(gestorProdutos.getProdutos(), quantidadeMinima);
                    break;

                case 8:
                    sistemaAtivo = false;
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
