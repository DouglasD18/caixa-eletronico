package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {
  private static Banco banco;
  private static PessoaCliente pessoaCliente;

  @BeforeAll
  public static void initAll() {
    banco = new Banco();
    pessoaCliente = banco.adicionarPessoaCliente("any_name", "any_cpf", "any_senha");
    banco.adicionarConta("Poupança", pessoaCliente);
    banco.adicionarConta("Corrente", pessoaCliente);
    banco.depositar(pessoaCliente, 1, 500.0);
  }

  @Test
  @Order(1)
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    String retorno = banco.gerarNumeroNovaConta();
    assertEquals(10, retorno.length());
  }

  @Test
  @Order(2)
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    PessoaCliente pessoaCliente2 = banco.adicionarPessoaCliente("name", "cpf", "senha");
    assertTrue(pessoaCliente2 instanceof PessoaCliente);
  }

  @Test
  @Order(3)
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    PessoaCliente primeira = banco.pessoaClienteLogin("cpf", "any_senha");
    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente("any_name", "any_cpf", "any_senha");
    PessoaCliente segunda = banco.pessoaClienteLogin("any_cpf", "any_senha");
    assertTrue(primeira == null);
    assertNotNull(segunda);
    assertEquals(segunda.getCpf(), pessoaCliente.getCpf());
  }

  @Test
  @Order(4)
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    banco.transferirFundos(pessoaCliente, 1, 0, 200);
    double saldo1 = pessoaCliente.retornarSaldoContaEspecifica(0);
    double saldo2 = pessoaCliente.retornarSaldoContaEspecifica(1);
    assertEquals(200, saldo1);
    assertEquals(300.0, saldo2);
  }

  @Test
  @Order(5)
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    banco.sacar(pessoaCliente, 1, 150);
    double saldo = pessoaCliente.retornarSaldoContaEspecifica(1);
    assertEquals(150.0, saldo);
  }

}
