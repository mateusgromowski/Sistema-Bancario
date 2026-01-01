package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private LocalDateTime diaEHora;
    private String horaFormatada;
    private String diaFormatado;
    private Tipo tipoTransacao;
    private double valor;
    private String numeroConta;

    public Transacao(Tipo tipoTransacao, double valor, String numeroConta) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.numeroConta = numeroConta;

        this.diaEHora = LocalDateTime.now();
        this.diaFormatado = diaEHora.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        this.horaFormatada = diaEHora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public Tipo getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public String getHoraFormatada() {
        return horaFormatada;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getDiaFormatado() {
        return diaFormatado;
    }

}
