package banco;

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

    public boolean depositar(double dinheiro) {
        if (dinheiro <= 0) {
            return false;
        }
        this.saldo += dinheiro;
        return true;
    }

    public boolean sacar(double dinheiro) {
        if (dinheiro <= 0) {
            return false;
        }

        if (dinheiro > this.saldo) {
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
