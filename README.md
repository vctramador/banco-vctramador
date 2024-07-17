# Projeto Banco VCTramador

Este é um projeto de banco digital desenvolvido em Java. Ele permite criar contas, realizar depósitos, saques e consultar saldos utilizando um banco de dados MySQL.

## Configuração

### Pré-requisitos

- Java Development Kit (JDK)
- MySQL
- MySQL Connector/J (biblioteca JDBC)

### Configuração do Banco de Dados

1. Crie um banco de dados MySQL:

    ```sql
    CREATE DATABASE banco;
    USE banco;
    CREATE TABLE contas (
        numeroConta BIGINT PRIMARY KEY,
        nome VARCHAR(100),
        cpf VARCHAR(20),
        email VARCHAR(100),
        senha VARCHAR(100),
        saldo DOUBLE
    );
    ```

2. Configure as variáveis de ambiente:

    No Windows:

    ```cmd
    set DB_URL=jdbc:mysql://localhost:3306/banco
    set DB_USER=root
    set DB_PASSWORD=Sr_viit1nho
    ```

### Compilação e Execução do Projeto

1. Compile o projeto:

    ```sh
    javac -d bin src/main/java/com/bancoVCTramador/*.java
    ```

2. Execute o projeto:

    ```sh
    java -cp "bin;lib/mysql-connector-j-8.4.0.jar" main.java.com.bancoVCTramador.Banco
    ```

## Funcionalidades

- Criar conta
- Depositar
- Sacar
- Consultar saldo

## Estrutura do Projeto

```plaintext
src/
└── main/
    └── java/
        └── com/
            └── bancoVCTramador/
                ├── Banco.java
                ├── Conta.java
                └── BancoGUI.java (se aplicável)


### README em Inglês

```markdown
# VCTramador Bank Project

This is a digital bank project developed in Java. It allows creating accounts, making deposits, withdrawals, and checking balances using a MySQL database.

## Configuration

### Prerequisites

- Java Development Kit (JDK)
- MySQL
- MySQL Connector/J (JDBC library)

### Database Setup

1. Create a MySQL database:

    ```sql
    CREATE DATABASE banco;
    USE banco;
    CREATE TABLE contas (
        numeroConta BIGINT PRIMARY KEY,
        nome VARCHAR(100),
        cpf VARCHAR(20),
        email VARCHAR(100),
        senha VARCHAR(100),
        saldo DOUBLE
    );
    ```

2. Set environment variables:

    On Windows:

    ```cmd
    set DB_URL=jdbc:mysql://localhost:3306/banco
    set DB_USER=root
    set DB_PASSWORD=Sr_viit1nho
    ```

### Compiling and Running the Project

1. Compile the project:

    ```sh
    javac -d bin src/main/java/com/bancoVCTramador/*.java
    ```

2. Run the project:

    ```sh
    java -cp "bin;lib/mysql-connector-j-8.4.0.jar" main.java.com.bancoVCTramador.Banco
    ```

## Features

- Create account
- Deposit
- Withdraw
- Check balance

## Project Structure

```plaintext
src/
└── main/
    └── java/
        └── com/
            └── bancoVCTramador/
                ├── Banco.java
                ├── Conta.java
                └── BancoGUI.java (if applicable)
