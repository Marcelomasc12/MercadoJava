package mercado;

public class Caixa {
    private double valorInicial;
    private double valorAtual;
    private double totalVendas;

    public void abrirCaixa(double valorInicial) {
        this.valorInicial = valorInicial;
        this.valorAtual = valorInicial;
        this.totalVendas = 0;
        System.out.println("Caixa aberto com R$" + valorInicial);
    }

    public void registrarVenda(double valorVenda) {
        this.valorAtual += valorVenda;
        this.totalVendas += valorVenda;
    }

    public void fecharCaixa() {
        System.out.println("Total de vendas: R$" + totalVendas);
        System.out.println("Valor final no caixa: R$" + valorAtual);
    }
}

