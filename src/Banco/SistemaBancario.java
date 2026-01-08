package banco;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public Conta criarConta(String titular, double saldo) {
        if (saldo <= 0) {
            return null;
        }
        Conta conta = new Conta(titular, saldo);
        contas.add(conta);
        return conta;
    }

    public boolean depositar(String numero, double dinheiro) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                if (conta.depositar(dinheiro)) {
                    addTransacao(Tipo.DEPOSITO, dinheiro, numero);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sacar(String numero, double dinheiro) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                if (conta.sacar(dinheiro)) {
                    addTransacao(Tipo.SAQUE, dinheiro, numero);
                }
                return true;
            }
        }
        return false;
    }

    private void addTransacao(Tipo tipo, double dinheiro, String numero) {
        transacoes.add(new Transacao(tipo, dinheiro, numero));
    }

    public Conta procurarConta(String numero) {
        for (Conta conta : contas) {
            if (numero.equals(conta.getNumero())) {
                return conta;
            }
        }
        return null;
    }

    public List<Transacao> getTransacoesDaConta(Conta conta) {
        List<Transacao> transacoesConta = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getNumeroConta().equals(conta.getNumero())) {
                transacoesConta.add(transacao);
            }
        }
        if (transacoesConta.size() == 0) {
            return null;
        }

        return transacoesConta;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

}
