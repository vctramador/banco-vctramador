package main.java.com.bancoDigital;

public class testes {
    public static void main(String[] args) {
        Banco banco = new Banco();
    
        // Testar conexão com o banco de dados
        if (banco.testarConexao()) {
            System.out.println("Conexão bem-sucedida.");
        } else {
            System.out.println("Conexão falhou.");
        }
    
        // Tentar criar uma nova conta
        Conta novaConta = banco.criarConta("Victor", "12345678901", "victor@example.com", "senha123");
        if (novaConta != null) {
            System.out.println("Conta criada com sucesso: " + novaConta.getNumeroConta());
    
            // Realizar depósito
            novaConta.depositar(100.0, banco);
            System.out.println("Depósito realizado. Saldo atual: " + novaConta.getSaldo());
        } else {
            System.out.println("Falha ao criar conta.");
        }
    }
    
}
