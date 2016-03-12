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
        String sql = "SELECT f.idfornecedores,f.nome,f.cpf,f.email,f.telefone,f.telcomercial,\n" +
                     "f.endereco,f.num,f.complemento,f.bairro,c.nome,e.uf,f.cep\n" +
                     "FROM fornecedores f INNER JOIN cidades c ON f.fkcidade = c.idcidades\n" +
                     "INNER JOIN estados e ON e.idestados = c.fkestado";
        
         try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mForCiBaUf = new ModelFornecedorCidadeUf();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mForCiBaUf.setId(rs.getInt("f.idfornecedores"));
                this.mForCiBaUf.setNome(rs.getString("f.nome"));
                this.mForCiBaUf.setCnpj_cpf(rs.getString("f.cpf"));
                this.mForCiBaUf.setEmail(rs.getString("f.email"));
                this.mForCiBaUf.setTelefone(rs.getString("f.telefone"));
                this.mForCiBaUf.setTelcomercial(rs.getString("f.telcomercial"));
                this.mForCiBaUf.setEndereco(rs.getString("f.endereco"));
                this.mForCiBaUf.setNum(rs.getString("f.num"));
                this.mForCiBaUf.setComeplemento(rs.getString("f.complemento"));
                this.mForCiBaUf.setBairro(rs.getString("f.bairro"));
                this.mForCiBaUf.setCidade(rs.getString("c.nome"));
                this.mForCiBaUf.setUf(rs.getString("e.uf"));
                this.mForCiBaUf.setCep(rs.getString("f.cep"));
                

                ListforCiBaUf.add(this.mForCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"tabela fornecedores:"+ e);
        }
        // retonar os dados para preencher a tabela
        return ListforCiBaUf;
 
    }
}
