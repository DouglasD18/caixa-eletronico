package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {

  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Construtor.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    System.out
        .println("Nova pessoa cliente " + this.nomeCompleto + " com CPF: " + this.cpf + " criada!");
  }

  /**
   * Adiciona conta.
   */
  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  /**
   * Retorna número de contas.
   */
  public int retornaNumeroDeContas() {
    return contas.size();
  }

  /**
   * Retorna Id da conta.
   */
  public String retornarIdContaEspecifica(int indice) {
    return contas.get(indice).getIdConta();
  }

  /**
   * Valida senha.
   */
  public boolean validarSenha(String senha) {
    if (senha == this.senha) {
      return true;
    }

    return false;
  }

  /**
   * Retorna CPF.
   */
  public String getCpf() {
    return this.cpf;
  }

  /**
   * Adiciona transação à conta.
   */
  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  /**
   * Retorna saldo da conta.
   */
  public double retornarSaldoContaEspecifica(int indice) {
    return contas.get(indice).retornarSaldo();
  }

  /**
   * Retorna extrato da conta.
   */
  public void retornarExtratoContaEspecifica(int indice) {
    contas.get(indice).retornarExtrato();
  }

  /**
   * Printa resumo das contas.
   */
  public void retornarResumoContas() {
    for (Conta conta : contas) {
      System.out.println(conta.retornarResumoConta());;
    }
  }

}
