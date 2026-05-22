package Estacionamento.Entities;

public class estacionamento1 {
    private int vagasDisponiveis;

    public estacionamento1() {
        this.vagasDisponiveis = 5;
    }
    public boolean verificarVagas() {
        return vagasDisponiveis > 0;
    }
    public void ocuparVaga() {
        vagasDisponiveis--;
    }
    public void liberarVaga() {
        vagasDisponiveis++;
    }
    public double calcularValor(int tempoHoras) {
        if (tempoHoras <= 1) {
            return 10.00;
        } else {
            return 10.00 + ((tempoHoras - 1) * 5.00);
        }
    }
    public void exibirFormasPagamento() {
        System.out.println("\nFormas de Pagamento Disponiveis:");
        System.out.println("1 - Cartao de Credito");
        System.out.println("2 - Cartao de Debito");
        System.out.println("3 - Pix");
    }
    public boolean processarPagamento(String opcao) {
        if (opcao.equals("1") || opcao.equals("2") || opcao.equals("3")) {
            return true;
        }
        return false;
    }
}