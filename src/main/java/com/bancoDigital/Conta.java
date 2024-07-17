package main.java.com.bancoDigital;

public class Conta {
    private long numeroConta;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private double saldo;

    public Conta(String nome, String cpf, String email, String senha, long numeroConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public Conta(String nome, String cpf, String email, String senha, long numeroConta, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor, Banco banco) {
        saldo += valor;
        banco.atualizarSaldo(numeroConta, saldo);
    }

    public boolean sacar(double valor, Banco banco) {
        if (saldo >= valor) {
            saldo -= valor;
            banco.atualizarSaldo(numeroConta, saldo);
            return true;
        } else {
            return false;
        }
    }

    public Conta get(long numeroConta2) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }   
}
