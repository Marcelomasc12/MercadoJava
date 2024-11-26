package mercado;

public class Eletroeletronico extends Produto {
    private int garantiaMeses;

    public Eletroeletronico(String codigo, String nome, double precoUnitario, int quantidadeEstoque, int garantiaMeses) {
        super(codigo, nome, precoUnitario, quantidadeEstoque);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPrecoUnitario());
        System.out.println("Estoque: " + getQuantidadeEstoque());
        System.out.println("Garantia (meses): " + garantiaMeses);
    }
}
