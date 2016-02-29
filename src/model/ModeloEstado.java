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
public class ModeloEstado {
    
    private int estado_id;
    private String estado_uf;
    private String estado_nome;

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_uf() {
        return estado_uf;
    }

    public void setEstado_uf(String estado_uf) {
        this.estado_uf = estado_uf;
    }

    public String getEstado_nome() {
        return estado_nome;
    }

    public void setEstado_nome(String estado_nome) {
        this.estado_nome = estado_nome;
    }
    
    
    
}
