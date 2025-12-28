package Banco;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public void criarConta(String titular, double saldo) {
        contas.add(new Conta(titular, saldo));
    }

    public void depositar(String numero, double dinheiro) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                if (conta.depositar(dinheiro)) {
                    addTransacao(Tipo.DEPOSITO, dinheiro, numero);
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void sacar(String numero, double dinheiro) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                if (conta.sacar(dinheiro)) {
                    addTransacao(Tipo.SAQUE, dinheiro, numero);
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private void addTransacao(Tipo tipo, double dinheiro, String numero) {
        transacoes.add(new Transacao(tipo, dinheiro, numero));
    }

}
