package Estacionamento;

import Estacionamento.Entities.estacionamento1;
import Estacionamento.Entities.Veiculo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        estacionamento1 controle = new estacionamento1();
        System.out.println("=== SISTEMA DE CONTROLE DE ESTACIONAMENTO ===");
        System.out.print("Informe a placa do veiculo: ");
        String placa = sc.nextLine();
        System.out.print("Informe o tipo do veiculo (carro ou moto): ");
        String tipo = sc.nextLine();

        if (controle.verificarVagas()) {
            controle.ocuparVaga();
            int entradaFicticia = 10;

            Veiculo veiculoAtual = new Veiculo(placa, tipo, entradaFicticia);
            System.out.println("\nVeiculo registrado com sucesso!");
            System.out.println("Horario de entrada: " + veiculoAtual.getHorarioEntrada() + "h");
            System.out.println("\n--- SIMULANDO MOMENTO DA SAIDA ---");
            System.out.print("Confirme a placa do veiculo para a saida: ");
            String placaSaida = sc.nextLine();

            if (placaSaida.equalsIgnoreCase(veiculoAtual.getPlaca())) {
                System.out.print("Informe o horario atual de saida (em horas inteiras): ");
                int horarioSaida = sc.nextInt();
                sc.nextLine();
                int tempoEstacionado = horarioSaida - veiculoAtual.getHorarioEntrada();
                int tempoCalculado = (tempoEstacionado <= 0) ? 1 : tempoEstacionado;
                double valorTotal = controle.calcularValor(tempoCalculado);
                System.out.println("\nResumo da Estadia:");
                System.out.println("Tempo estacionado: " + tempoCalculado + " hora(s)");
                System.out.println("Valor total a pagar: R$ " + valorTotal);
                controle.exibirFormasPagamento();
                System.out.print("\nEscolha a opcao de pagamento: ");
                String formaPgto = sc.nextLine();

                if (controle.processarPagamento(formaPgto)) {
                    controle.liberarVaga();
                    System.out.println("\nSaida liberada.");
                } else {
                    System.out.println("\nPagamento nao autorizado.");
                }
            } else {
                System.out.println("\nErro: Placa incorreta. Nao foi possivel processar a saida.");
            }
        } else {
            System.out.println("\nEstacionamento lotado.");
        }
        System.out.println("\nProcesso encerrado.");
    }
}