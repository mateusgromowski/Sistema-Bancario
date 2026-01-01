package frontendcli;

import java.util.List;
import java.util.Scanner;

import banco.SistemaBancario;
import banco.Conta;

public class FluxoDoUsuario {
    private SistemaBancario banco;
    private Scanner input = new Scanner(System.in);

    public FluxoDoUsuario(SistemaBancario banco) {
        this.banco = banco;
    }

    public void menuPrincipal() {
        outerLoop: while (true) {
            Menus.menuPrincipal();
            try {
                int escolha = input.nextInt();
                input.nextLine();
                if (escolha > 3 || escolha < 0) {
                    System.out.println("Entrada inválida.");
                    continue;
                }
                tratamentoDeEscolhas(escolha);
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                input.nextLine();
                continue;
            }
        }
    }

    public void tratamentoDeEscolhas(int escolha) {
        switch (escolha) {
            case 1:
                criacaoDeConta();
                break;
            case 0:
                System.exit(0);
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
            if (banco.criarConta(titular, saldo)) {
                System.out.println("Conta criada com sucesso.");
                String numeroConta = banco.encontraNumeroPorTitular(titular);
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
}
