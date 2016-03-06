/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wellington
 */
public class ModelCliente {
    private int cli_id;//codigo do cliente
    private String cli_nome;//nome do cliente
    private String cli_cpf;//cpf do cliente
    private String cli_email;//email do cliente
    private String cli_endereco;//endereco do cliente
    private String cli_numcasa;
    private String cli_complemento;
    private String cli_bairro;//bairro do cliente
    private int cli_idcidade;//refente a chaves estrangeira do banco
    private int cli_idestado;//refente a chaves estrangeira do banco
    private String cli_cep;//cep do cliente
    private String cli_telefone;//telefone do cliente
    private String cli_celular;//celular do cliente

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }
    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }
    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }
      public String getCli_numcasa() {
        return cli_numcasa;
    }

    public void setCli_numcasa(String cli_numcasa) {
        this.cli_numcasa = cli_numcasa;
    }

    public String getCli_complemento() {
        return cli_complemento;
    }

    public void setCli_complemento(String cli_complemento) {
        this.cli_complemento = cli_complemento;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String bairro) {
        this.cli_bairro = bairro;
    }

    public int getCli_idcidade() {
        return cli_idcidade;
    }

    public void setCli_idcidade(int cli_idcidade) {
        this.cli_idcidade = cli_idcidade;
    }

    public int getCli_idestado() {
        return cli_idestado;
    }

    public void setCli_idestado(int cli_idestado) {
        this.cli_idestado = cli_idestado;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    public String getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(String cli_celular) {
        this.cli_celular = cli_celular;
    }
    
}
