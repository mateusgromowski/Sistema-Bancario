package banco;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public String encontraNumeroPorTitular(String titular) {
        for (Conta conta : contas) {
            if (titular.equals(conta.getTitular())) {
                return conta.getNumero();
            }
        }
        return null;
    }

    public boolean criarConta(String titular, double saldo) {
        if (saldo <= 0) {
            System.out.println("O saldo não pode ser menor ou igual a zero.");
            return false;
        }
        contas.add(new Conta(titular, saldo));
        return true;
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

    public List<Conta> getContas() {
        return this.contas;
    }

}
