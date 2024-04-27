package br.com.controle;

import java.text.DecimalFormat;

public class Banco {
    public static synchronized void transferencia(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Transferência de R$" + df.format(valor) + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência de R$" + valor);
        }
    }
}
