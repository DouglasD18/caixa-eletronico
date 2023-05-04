package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("any_name", "any_cpf", "any_senha");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    assertTrue(conta instanceof Conta);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("any_name", "any_cpf", "any_senha");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    conta.adicionarTransacao(500.0, "Depósito");
    double saldo = conta.retornarSaldo();
    assertEquals(500.0, saldo);
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("any_name", "any_cpf", "any_senha");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    conta.adicionarTransacao(500.0, "Depósito");
    double saldo = conta.retornarSaldo();
    String resumo = conta.retornarResumoConta();
    assertTrue(resumo.contains(resumo));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    fail("Não implementado");
  }

}
