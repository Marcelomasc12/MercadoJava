package mercado;

import java.util.HashMap;
import java.util.Map;

public class Venda {
    private Map<Produto, Integer> itensVenda; // Produtos e suas quantidades.
    private double subtotal;

    public Venda() {
        this.itensVenda = new HashMap<>();
        this.subtotal = 0.0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (itensVenda.containsKey(produto)) {
            int quantidadeAtual = itensVenda.get(produto);
            itensVenda.put(produto, quantidadeAtual + quantidade);
        } else {
            itensVenda.put(produto, quantidade);
        }
        produto.atualizarEstoque(-quantidade); // Atualiza o estoque.
        calcularSubtotal();
    }

    public void removerProduto(Produto produto) {
        if (itensVenda.containsKey(produto)) {
            int quantidade = itensVenda.remove(produto); // Remove o produto da venda.
            produto.atualizarEstoque(quantidade);
        calcularSubtotal();
    }

    public double calcularSubtotal() {
        subtotal = 0.0;
        for (Map.Entry<Produto, Integer> entry : itensVenda.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            subtotal += produto.getPrecoUnitario() * quantidade;
        }
        return subtotal;
    }

    public double finalizarVenda() {
        System.out.println("Venda finalizada. Subtotal: R$ " + subtotal);
        return subtotal;
    }
}
