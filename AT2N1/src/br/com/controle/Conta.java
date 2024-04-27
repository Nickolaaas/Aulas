package br.com.controle;

public class Conta {
    private double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    public synchronized void sacar(double valor) {
        saldo -= valor;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}
