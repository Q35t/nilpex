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
public class ModelProduto {
    
    private int pro_id;
    private String pro_nome;
    private double pro_valor;
    private int pro_estoq;
    private byte[] pro_imagen;
    private int pro_idfornecedor;

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public double getPro_valor() {
        return pro_valor;
    }

    public void setPro_valor(double pro_valor) {
        this.pro_valor = pro_valor;
    }

    public int getPro_estoq() {
        return pro_estoq;
    }

    public void setPro_estoq(int pro_estoq) {
        this.pro_estoq = pro_estoq;
    }

    public byte[] getPro_imagen() {
        return pro_imagen;
    }

    public void setPro_imagen(byte[] pro_imagen) {
        this.pro_imagen = pro_imagen;
    }

    public int getPro_idfornecedor() {
        return pro_idfornecedor;
    }

    public void setPro_idfornecedor(int pro_idfornecedor) {
        this.pro_idfornecedor = pro_idfornecedor;
    }

    
    
}
