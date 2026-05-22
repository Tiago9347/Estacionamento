package Estacionamento.Entities;

public class Veiculo {
    private String placa;
    private String tipo;
    private int horarioEntrada;

    public Veiculo(String placa, String tipo, int horarioEntrada) {
        this.placa = placa;
        this.tipo = tipo;
        this.horarioEntrada = horarioEntrada;
    }
    public String getPlaca() {
        return this.placa;
    }
    public String getTipo() {
        return this.tipo;
    }
    public int getHorarioEntrada() {
        return this.horarioEntrada;
    }
}