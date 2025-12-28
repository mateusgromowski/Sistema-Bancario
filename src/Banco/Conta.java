package Banco;

public class Conta {
    private String titular;
    private double saldo;
    private static int numeroInt;
    private String numero;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        numeroInt++;
        this.numero = numeroInt < 10 ? "00" + numeroInt : numeroInt < 100 ? "0" + numeroInt : "" + numeroInt;
    }

    protected boolean depositar(double dinheiro) {
        if (dinheiro <= 0) {
            System.out.println("O valor de depósito não pode ser menor ou igual a zero.");
            return false;
        }
        this.saldo += dinheiro;
        return true;
    }

    protected boolean sacar(double dinheiro) {
        if (dinheiro <= 0) {
            System.out.println("O valor de saque não pode ser menor ou igual a zero.");
            return false;
        }

        if (dinheiro > this.saldo) {
            System.out.println("O valor de saque não pode ser maior que o saldo.");
            return false;
        }
        this.saldo -= dinheiro;
        return true;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

}
