/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoJdbc;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.ModelFornecedorCidadeBairroUf;

/**
 *
 * @author wellington
 */
public class ControllerFornecedorCidadeBairroUf {
    //controle para a tabela de fornecedores
    
    private Connection con;
    private ModelFornecedorCidadeBairroUf mForCiBaUf;
    
    public ControllerFornecedorCidadeBairroUf(){
        this.con = ConexaoJdbc.getConexao();
        mForCiBaUf = new ModelFornecedorCidadeBairroUf();
    }
    
    public List select() {
        List<ModelFornecedorCidadeBairroUf> ListCliCiBaUf = new ArrayList<ModelFornecedorCidadeBairroUf>();
        String sql = "";
    
        
        return null;
    }
}
