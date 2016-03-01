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
import model.ModelClienteCidadeBairroUf;

/**
 *
 * @author wellington
 */
public class ControllerClienteCidadeBairroUf {
    
    //controle para tabela de clientes
    
    private Connection con;
    private ModelClienteCidadeBairroUf mCliCiBaUf;
    
    public ControllerClienteCidadeBairroUf(){
        this.con = ConexaoJdbc.getConexao();
        mCliCiBaUf = new ModelClienteCidadeBairroUf();
    }
    
    public List select() {
        List<ModelClienteCidadeBairroUf> ListCliCiBaUf = new ArrayList<ModelClienteCidadeBairroUf>();
        String sql = "SELECT tab_cadcliente.cli_id, tab_cadcliente.cli_nome, tab_cadcliente.cli_email,\n" +
                     " tab_cadcliente.cli_telefone, tab_cadcliente.cli_celular, tab_cadcliente.cli_numcasa,\n" +
                     " tab_cadbairro.bairro_nome, tab_cadcidade.cid_nome , tab_estado.estado_nome \n" +
                     " FROM tab_cadcliente INNER JOIN tab_cadcidade \n" +
                     " ON tab_cadcliente.cli_idcidade = tab_cadcidade.cid_id\n" +
                     " INNER JOIN tab_cadbairro ON tab_cadcliente.cli_idbairro = tab_cadbairro.bairro_id\n" +
                     " INNER JOIN tab_estado ON tab_cadcliente.cli_idestado = tab_estado.estado_id";
    
    
    
        return null;
    
    }
    
}
