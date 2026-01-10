package banco;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
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
                    return true;
                }
            }
        }
        return false;
    }

    public Conta procurarConta(String numero) {
        for (Conta conta : contas) {
            if (numero.equals(conta.getNumero())) {
                return conta;
            }
        }
        return null;
    }

}
