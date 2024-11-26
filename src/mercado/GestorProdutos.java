package mercado;


import java.util.ArrayList;
import java.util.List;

public class GestorProdutos {
    private List<Produto> produtos;

    public GestorProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso: " + produto.getNome());
    }

    public Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }

    public List<Produto> getProdutosAlimentos() {
        List<Produto> alimentosUtensilios = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof AlimentoUtensilio) {
                alimentosUtensilios.add(produto);
            }
        }
        return alimentosUtensilios;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}

