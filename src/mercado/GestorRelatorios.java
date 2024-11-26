package mercado;

import java.util.List;

public class GestorRelatorios {

    // Relatório de Produtos a Vencer
    public void gerarRelatorioVencimento(List<Produto> produtos, int dias) {
        System.out.println("\n=== Relatório de Produtos a Vencer em " + dias + " dias ===");
        boolean encontrou = false;

        for (Produto produto : produtos) {
            if (produto instanceof AlimentoUtensilio) {
                AlimentoUtensilio alimento = (AlimentoUtensilio) produto;
                if (alimento.getValidadeDias() <= dias) {
                    alimento.exibirDetalhes();
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto a vencer dentro do período informado.");
        }
    }

    // Relatório de Produtos com Baixa Quantidade
    public void gerarRelatorioBaixaQuantidade(List<Produto> produtos, int quantidadeLimite) {
        System.out.println("\n=== Relatório de Produtos com Estoque Igual ou Inferior a " + quantidadeLimite + " ===");
        boolean encontrou = false;

        for (Produto produto : produtos) {
            if (produto.getQuantidadeEstoque() <= quantidadeLimite) {
                produto.exibirDetalhes();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }
}
