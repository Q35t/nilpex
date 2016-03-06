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
import model.ModelFornecedorCidadeUf;

/**
 *
 * @author wellington
 */
public class ControllerFornecedorCidadeUf {
    
    //controle para a tabela de fornecedores
    private Connection con;
    private ModelFornecedorCidadeUf mForCiBaUf;
    
    public ControllerFornecedorCidadeUf(){
        this.con = ConexaoJdbc.getConexao();
        mForCiBaUf = new ModelFornecedorCidadeUf();
    }
    
    public List select() {
        List<ModelFornecedorCidadeUf> ListforCiBaUf = new ArrayList<ModelFornecedorCidadeUf>();
        String sql = "SELECT f.for_id,f.for_nome,f.for_cnpj_cpf,f.for_email,f.for_telefone,f.for_telcomercial,\n" +
                     "f.for_endereco,f.for_num,f.for_complemento,f.for_bairro,c.cid_nome,e.estado_uf,f.for_cep\n" +
                     "FROM tab_cadfornecedor f INNER JOIN tab_cadcidade c ON f.for_idcidade = c.cid_id\n" +
                     "INNER JOIN tab_estado e ON f.for_idestado = e.estado_id; ";
        
         try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mForCiBaUf = new ModelFornecedorCidadeUf();
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
                this.mForCiBaUf.setBairro(rs.getString("f.for_bairro"));
                this.mForCiBaUf.setCidade(rs.getString("c.cid_nome"));
                this.mForCiBaUf.setUf(rs.getString("e.estado_uf"));
                this.mForCiBaUf.setCep(rs.getString("f.for_cep"));
                

                ListforCiBaUf.add(this.mForCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"tabela fornecedores:"+ e);
        }
        // retonar os dados para preencher a tabela
        return ListforCiBaUf;
 
    }
}
