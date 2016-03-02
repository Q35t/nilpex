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
        List<ModelFornecedorCidadeBairroUf> ListforCiBaUf = new ArrayList<ModelFornecedorCidadeBairroUf>();
        String sql = "SELECT f.for_id,f.for_nome,f.for_cnpj_cpf,f.for_email,f.for_telefone,f.for_telcomercial,\n" +
                     "f.for_endereco,f.for_num,f.for_complemento,b.bairro_nome,c.cid_nome,e.estado_nome,f.for_cep\n" +
                     "FROM tab_cadfornecedor f INNER JOIN tab_cadcidade c ON f.for_idcidade = c.cid_id\n" +
                     "INNER JOIN tab_cadbairro b ON f.for_idbairro = b.bairro_id\n" +
                     "INNER JOIN tab_estado e ON f.for_idestado = e.estado_id; ";
        
         try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mForCiBaUf = new ModelFornecedorCidadeBairroUf();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mForCiBaUf.setId(rs.getInt("f.for_id"));
                this.mForCiBaUf.setNome(rs.getString("f.for_nome"));
                this.mForCiBaUf.setCnpj_cpf(rs.getString("f.for_cnpj_cpf"));
                this.mForCiBaUf.setEmail(rs.getString("f.for_email"));
                this.mForCiBaUf.setTelefone(rs.getString("f.for_telefone"));
                this.mForCiBaUf.setTelcomercial(rs.getString("f.for_telcomercial"));
                this.mForCiBaUf.setEndereco(rs.getString("f.for_endereco"));
                this.mForCiBaUf.setNum(rs.getString("f.for_num"));
                this.mForCiBaUf.setComeplemento(rs.getString("f.for_complemento"));
                this.mForCiBaUf.setBairro(rs.getString("b.bairro_nome"));
                this.mForCiBaUf.setCidade(rs.getString("c.cid_nome"));
                this.mForCiBaUf.setUf(rs.getString("e.estado_nome"));
                this.mForCiBaUf.setCep(rs.getString("f.for_cep"));
                

                ListforCiBaUf.add(this.mForCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // retonar os dados para preencher a tabela
        return ListforCiBaUf;
 
    }
}
