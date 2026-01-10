package banco;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String titular;
    private double saldo;
    private static int numeroInt;
    private String numero;
    private List<Transacao> transacoes;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.transacoes = new ArrayList<>();
        this.saldo = saldo;
        numeroInt++;
        this.numero = numeroInt < 10 ? "00" + numeroInt : numeroInt < 100 ? "0" + numeroInt : "" + numeroInt;
    }

    public boolean depositar(double dinheiro) {
        if (dinheiro <= 0) {
            return false;
        }
        this.saldo += dinheiro;
        addTransacao(Tipo.DEPOSITO, dinheiro, this.numero);
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
        addTransacao(Tipo.SAQUE, dinheiro, this.numero);
        return true;
    }

    public void addTransacao(Tipo tipo, double dinheiro, String numero) {
        transacoes.add(new Transacao(tipo, dinheiro, numero));
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

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

}
