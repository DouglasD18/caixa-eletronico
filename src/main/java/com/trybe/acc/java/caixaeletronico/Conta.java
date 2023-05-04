package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * Construtor.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  /**
   * Retorna saldo.
   */
  public double retornarSaldo() {
    double saldo = 0;
    for (Transacao transacao : transacoes) {
      saldo += transacao.getQuantia();
    }

    return saldo;
  }

  /**
   * Retorna Id da conta.
   */
  public String getIdConta() {
    return this.idConta;
  }

  /**
   * Retorna Pessoa CLiente.
   */
  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  /**
   * Printa o extrato.
   */
  public void retornarExtrato() {
    for (Transacao transacao : transacoes) {
      String resumo = transacao.retornarResumoTransacao();
      System.out.println(resumo + "\n");
    }
  }

  /**
   * Adiciona transação.
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
   * Printa resumo da conta.
   */
  public String retornarResumoConta() {
    double saldo = retornarSaldo();
    return this.idConta + " : " + saldo + " : " + this.tipoConta;
  }

}
