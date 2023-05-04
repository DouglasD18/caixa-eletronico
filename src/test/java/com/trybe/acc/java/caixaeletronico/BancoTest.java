package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String retorno = banco.gerarNumeroNovaConta();
    assertEquals(10, retorno.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente("any_name", "any_cpf", "any_senha");
    assertTrue(pessoaCliente instanceof PessoaCliente);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    PessoaCliente primeira = banco.pessoaClienteLogin("any_cpf", "any_senha");
    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente("any_name", "any_cpf", "any_senha");
    PessoaCliente segunda = banco.pessoaClienteLogin("any_cpf", "any_senha");
    assertTrue(primeira == null);
    assertNotNull(segunda);
    assertEquals(segunda.getCpf(), pessoaCliente.getCpf());
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    fail("Não implementado");

  }

}
