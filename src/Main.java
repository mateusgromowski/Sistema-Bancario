import banco.SistemaBancario;
import frontendcli.FluxoDoUsuario;

public class Main {
    public static void main(String[] args) {
        SistemaBancario banco = new SistemaBancario();
        FluxoDoUsuario fluxo = new FluxoDoUsuario(banco);
        fluxo.menuPrincipal();
    }
}
