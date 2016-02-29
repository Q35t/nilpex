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
        String sql = "SELECT tab_cadcidade.cid_id , tab_cadcidade.cid_nome, tab_estado.estado_uf, tab_estado.estado_nome "
                + "FROM tab_cadcidade inner join tab_estado on tab_estado.estado_id = tab_cadcidade.cid_idestado;";
        
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
                mCidadeEstado.setCid_id(rs.getInt("cid_id"));
                mCidadeEstado.setCid_nome(rs.getString("cid_nome"));
                mCidadeEstado.setEstado_uf(rs.getString("estado_uf"));
                mCidadeEstado.setEstado_nome(rs.getString("estado_nome"));

                ListCidadeEstado.add(mCidadeEstado);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCidadeEstado;
    }

    
}
