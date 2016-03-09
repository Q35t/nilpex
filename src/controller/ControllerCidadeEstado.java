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
import model.ModelCidadeEstado;

/**
 *
 * @author wellington
 */
public class ControllerCidadeEstado {
    
    private Connection con;
    
    public ControllerCidadeEstado(){
        this.con = ConexaoJdbc.getConexao();
    }
    
     public List select() {
        List<ModelCidadeEstado> ListCidadeEstado = new ArrayList<ModelCidadeEstado>();
        String sql = "SELECT cidades.idcidades , cidades.nome, estados.uf, estados.nome "
                + "FROM cidades inner join estados on estados.idestados = cidades.fkestado";
        
        PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table
            while (rs.next()) {
                ModelCidadeEstado mCidadeEstado = new ModelCidadeEstado();
                //rs retorna todos os dados do banco de cada campo
                //para mcc que mostra na tabela
                mCidadeEstado.setCid_id(rs.getInt("idcidades"));
                mCidadeEstado.setCid_nome(rs.getString("nome"));//nome cidade
                mCidadeEstado.setEstado_uf(rs.getString("uf"));
                mCidadeEstado.setEstado_nome(rs.getString("estados.nome"));//nome estado

                ListCidadeEstado.add(mCidadeEstado);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCidadeEstado;
    }

    
}
