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
public class ModelBairro {
    
    private int bairro_id;
    private String bairro_nome;
    private int bairro_idcidade;
    private int bairro_iduf;

    public int getBairro_id() {
        return bairro_id;
    }

    public void setBairro_id(int bairro_id) {
        this.bairro_id = bairro_id;
    }

    public String getBairro_nome() {
        return bairro_nome;
    }

    public void setBairro_nome(String bairro_nome) {
        this.bairro_nome = bairro_nome;
    }

    public int getBairro_idcidade() {
        return bairro_idcidade;
    }

    public void setBairro_idcidade(int bairro_idcidade) {
        this.bairro_idcidade = bairro_idcidade;
    }

    public int getBairro_iduf() {
        return bairro_iduf;
    }

    public void setBairro_iduf(int bairro_iduf) {
        this.bairro_iduf = bairro_iduf;
    }
    
    
    
}
