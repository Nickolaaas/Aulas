package br.com.controle;

import java.util.Random;

public class Cliente extends Thread {
    private Conta conta;

    public Cliente(double saldoInicial) {
        conta = new Conta(saldoInicial);
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (conta.getSaldo() > 0) {
            double valorCompra = random.nextBoolean() ? 100 : 200;
        }
    }
}
