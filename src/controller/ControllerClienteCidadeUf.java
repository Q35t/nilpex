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
import model.ModelClienteCidadeUf;

/**
 *
 * @author wellington
 */
public class ControllerClienteCidadeUf {
    
    //controle para tabela de clientes
    
    private Connection con;
    private ModelClienteCidadeUf mCliCiBaUf;
    
    public ControllerClienteCidadeUf(){
        this.con = ConexaoJdbc.getConexao();
        mCliCiBaUf = new ModelClienteCidadeUf();
    }
    
    public List select() {
        List<ModelClienteCidadeUf> ListCliCiBaUf = new ArrayList<ModelClienteCidadeUf>();
        String sql = "SELECT cli.idclientes,cli.nome,cli.cpf,cli.email,cli.telefone,cli.celular,\n" +
                     "cli.endereco,cli.numcasa,cli.complemento,cli.bairro,cid.nome,est.uf, cli.cep\n" +
                     "FROM clientes cli INNER JOIN cidades cid ON cli.fkcidade = cid.idcidades INNER JOIN estados est ON cli.fkestado = est.idestados";

        try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mCliCiBaUf = new ModelClienteCidadeUf();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mCliCiBaUf.setId(rs.getInt("cli.idclientes"));
                this.mCliCiBaUf.setNome(rs.getString("cli.nome"));
                this.mCliCiBaUf.setCpf(rs.getString("cli.cpf"));
                this.mCliCiBaUf.setEmail(rs.getString("cli.email"));
                this.mCliCiBaUf.setTelefone(rs.getString("cli.telefone"));
                this.mCliCiBaUf.setCelular(rs.getString("cli.celular"));
                this.mCliCiBaUf.setEndereco(rs.getString("cli.endereco"));
                this.mCliCiBaUf.setNumcasa(rs.getString("cli.numcasa"));
                this.mCliCiBaUf.setComplemento(rs.getString("cli.complemento"));
                this.mCliCiBaUf.setBairro(rs.getString("cli.bairro"));
                this.mCliCiBaUf.setCidade(rs.getString("cid.nome"));
                this.mCliCiBaUf.setUf(rs.getString("est.uf"));
                this.mCliCiBaUf.setCep(rs.getString("cli.cep"));
                

                ListCliCiBaUf.add(this.mCliCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // retonar os dados para preencher a tabela
        return ListCliCiBaUf;
    
    }
    
}
