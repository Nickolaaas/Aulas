package br.com.visao;
import java.util.Random;
import br.com.controle.Banco;
import br.com.controle.Cliente;
import br.com.controle.Funcionario;
import br.com.controle.Loja;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Funcionario[] funcionariosLoja1 = {new Funcionario("Funcionário 1", 1400), new Funcionario("Funcionário 2", 1400)};
        Funcionario[] funcionariosLoja2 = {new Funcionario("Funcionário 3", 1400), new Funcionario("Funcionário 4", 1400)};
        Loja loja1 = new Loja(0, funcionariosLoja1);
        Loja loja2 = new Loja(0, funcionariosLoja2);

        Cliente[] clientes = {new Cliente(1000), new Cliente(1000), new Cliente(1000), new Cliente(1000), new Cliente(1000)};

        for (Funcionario funcionario : funcionariosLoja1) {
            funcionario.start();
        }
        for (Funcionario funcionario : funcionariosLoja2) {
            funcionario.start();
        }
        for (Cliente cliente : clientes) {
            cliente.start();
        }

     new Thread(() -> {
         while (true) {
             try {
                 Thread.sleep(5000); 
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             loja1.pagarSalarios();
             loja2.pagarSalarios();
         }
     }).start();

     new Thread(() -> {
         Random random = new Random();
         while (true) {
             Cliente clienteOrigem = clientes[random.nextInt(clientes.length)];
             Cliente clienteDestino = clientes[random.nextInt(clientes.length)];
             double valorTransferencia = random.nextDouble() * 200;
             Banco.transferencia(clienteOrigem.getConta(), clienteDestino.getConta(), valorTransferencia);
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }).start();

    }
}
