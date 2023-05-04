package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {

  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Gera número de conta aleatório.
   */
  private String geraNumeroAleatorio() {
    Random random = new Random();
    String numero = "";
    while (numero.length() < 10) {
      int randomNum = random.nextInt(10);
      if (randomNum > -1) {
        numero += randomNum;
      }
    }

    return numero;
  }

  /**
   * Verifica se o Id já existe.
   */
  private boolean verificaIds(String id) {
    for (PessoaCliente pessoaCliente : pessoasClientes) {
      int numeroDeContas = pessoaCliente.retornaNumeroDeContas();
      int indice = 0;
      while (indice < numeroDeContas) {
        if (pessoaCliente.retornarIdContaEspecifica(indice) == id) {
          return true;
        }
        indice++;
      }
    }

    return false;
  }

  /**
   * Gera um novi Id.
   */
  public String gerarNumeroNovaConta() {
    String id = geraNumeroAleatorio();
    do {
      if (verificaIds(id)) {
        id = geraNumeroAleatorio();
      } else {
        break;
      }
    } while (true);

    return id;
  }

  /**
   * Retorna PessoaCliente adicionada.
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoaCliente);
    return pessoaCliente;
  }

  /**
   * Adiciona nova conta.
   */
  public void adicionarConta(String tipoConta, PessoaCliente pessoaCliente) {
    Conta novaConta = new Conta(tipoConta, pessoaCliente, this);
    pessoaCliente.adicionarConta(novaConta);
    contas.add(novaConta);
  }

  /**
   * Faz login do cliente.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoaCliente : pessoasClientes) {
      if (pessoaCliente.validarSenha(senha) && pessoaCliente.getCpf() == cpf) {
        return pessoaCliente;
      }
    }

    return null;
  }

  /**
   * Realiza transferência entre contas.
   */
  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      double quantia) {
    if (contas.get(daConta) != null && contas.get(paraConta) != null && daConta != paraConta) {
      for (int indice = 0; indice < pessoaCliente.retornaNumeroDeContas(); indice++) {
        if (pessoaCliente.retornarIdContaEspecifica(indice) == contas.get(daConta).getIdConta()) {
          pessoaCliente.adicionarTransacaoContaEspecifica(indice, quantia, "Transferência enviada");
        }

        if (pessoaCliente.retornarIdContaEspecifica(indice) == contas.get(paraConta).getIdConta()) {
          pessoaCliente.adicionarTransacaoContaEspecifica(indice, quantia,
              "Transferência recebida");
        }
      }
    }

  }

  /**
   * Realiza saque.
   */
  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    if (contas.get(daConta) != null
        && pessoaCliente.retornarSaldoContaEspecifica(daConta) >= quantia) {
      for (int indice = 0; indice < pessoaCliente.retornaNumeroDeContas(); indice++) {
        if (pessoaCliente.retornarIdContaEspecifica(indice) == contas.get(daConta).getIdConta()) {
          pessoaCliente.adicionarTransacaoContaEspecifica(indice, quantia, "Saque Realizado!");
        }
      }
    }
  }

  /**
   * Realiza depósito.
   */
  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    if (contas.get(paraConta) != null) {
      for (int indice = 0; indice < pessoaCliente.retornaNumeroDeContas(); indice++) {
        if (pessoaCliente.retornarIdContaEspecifica(indice) == contas.get(paraConta).getIdConta()) {
          pessoaCliente.adicionarTransacaoContaEspecifica(indice, quantia, "Deposito Realizado!");
        }
      }
    }
  }

  /**
   * Printa extrato.
   */
  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    if (contas.get(conta) != null) {
      for (int indice = 0; indice < pessoaCliente.retornaNumeroDeContas(); indice++) {
        if (pessoaCliente.retornarIdContaEspecifica(indice) == contas.get(conta).getIdConta()) {
          pessoaCliente.retornarExtratoContaEspecifica(indice);
        }
      }
    }
  }

}
