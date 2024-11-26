package mercado;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double precoUnitario;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double precoUnitario, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void atualizarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void alterarPreco(double novoPreco) {
        this.precoUnitario = novoPreco;
    }

    public abstract void exibirDetalhes();
}

