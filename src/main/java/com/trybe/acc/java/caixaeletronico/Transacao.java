package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

  private double quantia;
  private String instante;
  private String descricao;

  /**
   * Método construtor da classe.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }

  /**
   * Retorna o instante atual.
   */
  public String retornarInstante() {
    String formato = "dd/MM/yyyy HH:mm:ss";
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern(formato);
    LocalDateTime now = LocalDateTime.now();
    return formatador.format(now);
  }

  /**
   * Retorna a quantia.
   */
  public double getQuantia() {
    return this.quantia;
  }

  /**
   * Retorna o resumo da transação.
   */
  public String retornarResumoTransacao() {
    return this.instante + " -------- " + this.descricao + ": R$ " + this.quantia;
  }

}

