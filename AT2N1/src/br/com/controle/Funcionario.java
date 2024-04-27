package br.com.controle;

import java.util.Random;

public class Funcionario extends Thread {
    private String nome;
    private double salario;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void receberSalario() {
        contaSalario.depositar(salario);
        double valorInvestimento = salario * 0.2;
        contaInvestimento.depositar(valorInvestimento);
        System.out.println("Salário de R$" + salario + " recebido por " + nome + ". R$" + valorInvestimento + " investido.");
    }

    @Override
    public void run() {
        // Implementação da lógica da thread, se necessário
    }
}
