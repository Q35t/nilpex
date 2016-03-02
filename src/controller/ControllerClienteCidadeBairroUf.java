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
        String sql = "SELECT cli.cli_id,cli.cli_nome,cli.cli_cpf,cli.cli_email,cli.cli_telefone,cli.cli_celular,\n" +
                     "cli.cli_endereco,cli.cli_numcasa,cli.cli_complemento,ba.bairro_nome,cid.cid_nome,est.estado_nome, cli.cli_cep\n" +
                     "FROM tab_cadcliente cli INNER JOIN tab_cadcidade cid ON cli.cli_idcidade = cid.cid_id INNER JOIN tab_estado est ON cli.cli_idestado = est.estado_id INNER JOIN tab_cadbairro ba ON cli.cli_idbairro = ba.bairro_id";

        try {
           
            PreparedStatement ps = this.con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                this.mCliCiBaUf = new ModelClienteCidadeBairroUf();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mCliCiBaUf.setId(rs.getInt("cli.cli_id"));
                this.mCliCiBaUf.setNome(rs.getString("cli.cli_nome"));
                this.mCliCiBaUf.setCpf(rs.getString("cli.cli_cpf"));
                this.mCliCiBaUf.setEmail(rs.getString("cli.cli_email"));
                this.mCliCiBaUf.setTelefone(rs.getString("cli.cli_telefone"));
                this.mCliCiBaUf.setCelular(rs.getString("cli.cli_celular"));
                this.mCliCiBaUf.setEndereco(rs.getString("cli.cli_endereco"));
                this.mCliCiBaUf.setNumcasa(rs.getString("cli.cli_numcasa"));
                this.mCliCiBaUf.setComplemento(rs.getString("cli.cli_complemento"));
                this.mCliCiBaUf.setBairro(rs.getString("ba.bairro_nome"));
                this.mCliCiBaUf.setCidade(rs.getString("cid.cid_nome"));
                this.mCliCiBaUf.setUf(rs.getString("est.estado_nome"));
                this.mCliCiBaUf.setCep(rs.getString("cli.cli_cep"));
                

                ListCliCiBaUf.add(this.mCliCiBaUf);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // retonar os dados para preencher a tabela
        return ListCliCiBaUf;
    
    }
    
}
