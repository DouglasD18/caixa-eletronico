package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(500.0, "Depósito");
    assertEquals(500.0, transacao.getQuantia());
    assertEquals(47, transacao.retornarResumoTransacao().length());
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(500.0, "Nova transacao");
    assertEquals(500.0, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(500.0, "Depósito");
    assertEquals(47, transacao.retornarResumoTransacao().length());
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(500.0, "Nova transacao");
    LocalDateTime data = LocalDateTime.now();
    String formato = "dd/MM/yyyy HH:mm";
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern(formato);
    assertTrue(transacao.retornarInstante().contains(formatador.format(data)));
  }

}
