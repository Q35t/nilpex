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
public class ModeloProdutoFornecedor {
    private int pro_id;
    private String pro_nome;
    private Double pro_valor;
    private int pro_quant;
    private String pro_fornecedor;

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

    public Double getPro_valor() {
        return pro_valor;
    }

    public void setPro_valor(Double pro_valor) {
        this.pro_valor = pro_valor;
    }

    public int getPro_quant() {
        return pro_quant;
    }

    public void setPro_quant(int pro_quant) {
        this.pro_quant = pro_quant;
    }

    public String getPro_fornecedor() {
        return pro_fornecedor;
    }

    public void setPro_fornecedor(String pro_fornecedor) {
        this.pro_fornecedor = pro_fornecedor;
    }
    
    
}
