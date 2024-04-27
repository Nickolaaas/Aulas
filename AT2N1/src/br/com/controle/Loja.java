package br.com.controle;

public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(double saldoInicial, Funcionario[] funcionarios) {
        this.conta = new Conta(saldoInicial);
        this.funcionarios = funcionarios;
    }

    public synchronized void pagarSalarios() {
        double totalSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios += funcionario.getSalario();
        }

        if (conta.getSaldo() >= totalSalarios) {
            for (Funcionario funcionario : funcionarios) {
                conta.sacar(funcionario.getSalario());
                funcionario.receberSalario();
                System.out.println("Salário de R$" + funcionario.getSalario() + " pago para " + funcionario.getNome());
            }
        } else {
            System.out.println("Saldo insuficiente para pagar os salários dos funcionários da loja.");
        }
    }
}
