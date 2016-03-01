/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
        String sql = "";

        try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mCliCiBaUf = new ModelClienteCidadeBairroUf();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mCliCiBaUf.setId(rs.getInt("tab_cadcliente.cli_id"));
                this.mCliCiBaUf.setNome(rs.getString("tab_cadcliente.cli_nome"));
                this.mCliCiBaUf.setEmail(rs.getString("tab_cadcliente.cli_email"));
                this.mCliCiBaUf.setTelefone(rs.getString("tab_cadcliente.cli_telefone"));
                this.mCliCiBaUf.setCelular(rs.getString("tab_cadcliente.cli_celular"));
                this.mCliCiBaUf.setEndereco(rs.getString("tab_cadcliente.cli_endereco"));
                this.mCliCiBaUf.setNumcasa(rs.getString("tab_cadcliente.cli_numcasa"));
                this.mCliCiBaUf.setComplemento(rs.getString("tab_cadcliente.cli_complemento"));
                this.mCliCiBaUf.setBairro(rs.getString("tab_cadbairro.bairro_nome"));
                this.mCliCiBaUf.setCidade(rs.getString("tab_cadcidade.cid_nome"));
                this.mCliCiBaUf.setUf(rs.getString(" tab_estado.estado_nome"));
                this.mCliCiBaUf.setCep(rs.getString("tab_cadcliente.cli_cep"));
                

                ListCliCiBaUf.add(this.mCliCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // retonar os dados para preencher a tabela
        return ListCliCiBaUf;
    
    }
    
}
