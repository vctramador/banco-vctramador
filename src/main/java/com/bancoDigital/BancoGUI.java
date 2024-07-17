package main.java.com.bancoDigital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI {
    private Banco banco;

    public BancoGUI() {
        banco = new Banco();
        initUI();
    }
// conta: 588495887
    private void initUI() {
        JFrame frame = new JFrame("Banco vctramador");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JButton criarContaButton = new JButton("Criar Conta");
        JButton consultarSaldoButton = new JButton("Consultar Saldo");
        JButton depositarButton = new JButton("Depositar");
        JButton sacarButton = new JButton("Sacar");
        JButton sairButton = new JButton("Sair");

        criarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });

        consultarSaldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarSaldo();
            }
        });

        depositarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        sacarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(criarContaButton);
        frame.add(consultarSaldoButton);
        frame.add(depositarButton);
        frame.add(sacarButton);
        frame.add(sairButton);

        frame.setVisible(true);
    }

    private void criarConta() {
        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField senhaField = new JTextField();
        Object[] message = {
            "Nome:", nomeField,
            "CPF:", cpfField,
            "Email:", emailField,
            "Senha:", senhaField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Criar Conta", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String email = emailField.getText();
            String senha = senhaField.getText();
            Conta novaConta = banco.criarConta(nome, cpf, email, senha);
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Seu número de conta é: " + novaConta.getNumeroConta());
        }
    }

    private void consultarSaldo() {
        String numeroContaStr = JOptionPane.showInputDialog("Insira o número da conta:");
        long numeroConta = Long.parseLong(numeroContaStr);
        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            JOptionPane.showMessageDialog(null, "Saldo da conta: R$" + conta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    private void depositar() {
        String numeroContaStr = JOptionPane.showInputDialog("Insira o número da conta:");
        long numeroConta = Long.parseLong(numeroContaStr);
        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            String valorStr = JOptionPane.showInputDialog("Insira o valor para depositar:");
            double valor = Double.parseDouble(valorStr);
            conta.depositar(valor, banco);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso! Saldo atual: R$" + conta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    private void sacar() {
        String numeroContaStr = JOptionPane.showInputDialog("Insira o número da conta:");
        long numeroConta = Long.parseLong(numeroContaStr);
        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            String valorStr = JOptionPane.showInputDialog("Insira o valor para sacar:");
            double valor = Double.parseDouble(valorStr);
            if (conta.sacar(valor, banco)) {
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Saldo atual: R$" + conta.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BancoGUI();
            }
        });
    }
}
