package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {
  private static Banco banco;
  private static PessoaCliente pessoaCliente;
  private static Conta conta;

  @BeforeAll
  public static void initAll() {
    banco = new Banco();
    pessoaCliente = new PessoaCliente("any_name", "any_cpf", "any_senha");
    conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
  }

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    assertTrue(conta instanceof Conta);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    conta.adicionarTransacao(500.0, "Depósito");
    double saldo = conta.retornarSaldo();
    assertEquals(500.0, saldo);
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    double saldo = conta.retornarSaldo();
    String resumo = conta.retornarResumoConta();
    assertTrue(resumo.contains(Double.toString(saldo)));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    conta.retornarExtrato();

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains(": R$ "));
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    String id = conta.getIdConta();
    assertNotNull(id);
    assertTrue(id instanceof String);
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    PessoaCliente cliente = conta.getPessoaCliente();
    assertEquals(cliente, pessoaCliente);
  }

}
