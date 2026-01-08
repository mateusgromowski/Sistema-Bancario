package frontendcli;

import java.util.List;
import java.util.Scanner;

import banco.SistemaBancario;
import banco.Tipo;
import banco.Transacao;
import banco.Conta;

public class FluxoDoUsuario {
    private SistemaBancario banco;
    private Scanner input = new Scanner(System.in);

    public FluxoDoUsuario(SistemaBancario banco) {
        this.banco = banco;
    }

    public void menuPrincipal() {
        while (true) {
            Menus.menuPrincipal();
            try {
                int escolha = input.nextInt();
                input.nextLine();
                if (escolha > 3 || escolha < 0) {
                    System.out.println("Entrada inválida.");
                    continue;
                }
                if (escolha == 0) {
                    break;
                }
                tratamentoDeEscolhasDoMenuPrincipal(escolha);
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                input.nextLine();
                continue;
            }
        }
    }

    private void tratamentoDeEscolhasDoMenuPrincipal(int escolha) {
        switch (escolha) {
            case 1:
                criacaoDeConta();
                break;
            case 2:
                acessarConta();
                break;
            default:
                System.out.println("Entrada inválida.");
                break;
        }
    }

    private void criacaoDeConta() {
        try {
            System.out.println("--- CRIAÇÃO DE CONTA ---");
            System.out.print("Nome do titular: ");
            String titular = input.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = input.nextDouble();
            input.nextLine();
            System.out.println();
            Conta novaConta = banco.criarConta(titular, saldo);
            if (novaConta != null) {
                System.out.println("Conta criada com sucesso.");
                String numeroConta = novaConta.getNumero();
                System.out.println("Número da conta: " + numeroConta);
                System.out.println();
                System.out.println("Pressione ENTER para continuar...");
                input.nextLine();
                return;
            }
            System.out.println("A conta não pôde ser criada.");
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
        }
    }

    private void acessarConta() {
        System.out.println();
        System.out.println("--- ACESSO À CONTA ---");
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        Conta conta = banco.procurarConta(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada");
            System.out.println("Verifique o número e tente novamente.");
            return;
        }
        menuDaConta(conta);
    }

    private void menuDaConta(Conta conta) {
        while (true) {
            System.out.println("------------------------------------");
            System.out.printf("Conta: %s | Titular: %s\n", conta.getNumero(), conta.getTitular());
            System.out.printf("Saldo: R$ %.2f\n", conta.getSaldo());
            System.out.println();
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Extrato");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            try {
                int escolha = input.nextInt();
                input.nextLine();
                if (escolha > 3 || escolha < 0) {
                    System.out.println("Entrada inválida.");
                    continue;
                }
                if (escolha == 0) {
                    break;
                }
                tratamentoDeEscolhasDaConta(escolha, conta);
            } catch (Exception e) {
                System.out.println("Entrada Incorreta.");
                input.nextLine();
            }
        }
    }

    private void tratamentoDeEscolhasDaConta(int escolha, Conta conta) {
        switch (escolha) {
            case 1:
                menuDeposito(conta);
                break;
            case 2:
                menuSaque(conta);
                break;
            case 3:
                getExtrato(conta);
                break;
        }
    }

    private void getExtrato(Conta conta) {
        System.out.println("========== EXTRATO ==========");
        System.out.println("Conta: " + conta.getNumero() + " - " + conta.getTitular());
        System.out.println();
        List<Transacao> transacoesDoUsuario = banco.getTransacoesDaConta(conta);
        if (transacoesDoUsuario == null) {
            System.out.println("Essa conta ainda não fez nenhuma transação.");
            return;
        }

        for (Transacao transacao : transacoesDoUsuario) {
            System.out.println("[" + transacao.getDiaFormatado() + " " + transacao.getHoraFormatada() + "] " +
                    transacao.getTipoTransacao() +
                    (transacao.getTipoTransacao().equals(Tipo.DEPOSITO) ? " +" + transacao.getValor()
                            : "    -" + transacao.getValor()));
        }
        System.out.printf("Saldo atual: R$ %.2f\n", conta.getSaldo());
    }

    private void menuSaque(Conta conta) {
        System.out.println("--- SAQUE ---");
        System.out.println();
        System.out.print("Valor do saque: ");
        try {
            double valorDoSaque = input.nextDouble();
            input.nextLine();
            if (banco.sacar(conta.getNumero(), valorDoSaque)) {
                System.out.println("Saque realizado com sucesso!");
                System.out.printf("Novo saldo: R$ %.2f\n", conta.getSaldo());
            } else {
                System.out.println("Valor inválido.");
                System.out.println("Depósito deve ser maior do que zero.");
            }
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            input.nextLine();
        }
    }

    private void menuDeposito(Conta conta) {
        System.out.println("--- DEPÓSITO ---");
        System.out.println();
        System.out.print("Valor do depósito: ");
        try {
            double valor = input.nextDouble();
            input.nextLine();
            if (banco.depositar(conta.getNumero(), valor)) {
                System.out.println("Depósito realizado com sucesso!");
                System.out.printf("Novo saldo R$ %.2f\n", conta.getSaldo());
            } else {
                System.out.println("Valor inválido.");
                System.out.println("Depósito deve ser maior do que zero.");
            }
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            input.nextLine();
        }

    }
}
