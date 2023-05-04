package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private static Banco banco;
  private static PessoaCliente pessoaCliente;
  private static Conta conta;
  private static int zero;

  @BeforeAll
  public static void initAll() {
    banco = new Banco();
    pessoaCliente = new PessoaCliente("any_name", "any_cpf", "any_senha");
    conta = new Conta("Corrente", pessoaCliente, banco);
    zero = pessoaCliente.retornaNumeroDeContas();
    pessoaCliente.adicionarConta(conta);
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    assertNotNull(pessoaCliente);
    assertTrue(pessoaCliente instanceof PessoaCliente);
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    int uma = pessoaCliente.retornaNumeroDeContas();
    assertEquals(0, zero);
    assertEquals(1, uma);
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    double saldo = pessoaCliente.retornarSaldoContaEspecifica(0);
    assertEquals(0, saldo);
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    String idConta = conta.getIdConta();
    String id = pessoaCliente.retornarIdContaEspecifica(0);
    assertEquals(idConta, id);
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    conta.adicionarTransacao(200, "Depósito");;
    pessoaCliente.retornarExtratoContaEspecifica(0);
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 150, "Transferência");
    pessoaCliente.retornarExtratoContaEspecifica(0);
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    assertTrue(pessoaCliente.validarSenha("any_senha"));
    assertFalse(pessoaCliente.validarSenha("senha"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    pessoaCliente.retornarResumoContas();
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    String cpf = pessoaCliente.getCpf();
    assertEquals("any_cpf", cpf);
  }

}
