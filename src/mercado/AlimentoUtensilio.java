package mercado;

public class AlimentoUtensilio extends Produto {
    private int validadeDias;

    public AlimentoUtensilio(String codigo, String nome, double precoUnitario, int quantidadeEstoque, int validadeDias) {
        super(codigo, nome, precoUnitario, quantidadeEstoque);
        this.validadeDias = validadeDias;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Código: " + getCodigo() +
                ", Nome: " + getNome() +
                ", Preço: R$ " + getPrecoUnitario() +
                ", Estoque: " + getQuantidadeEstoque() +
                ", Validade: " + validadeDias + " dias");
    }
}
