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
import model.ModelBairroCidadeEstado;

/**
 *
 * @author wellington
 */
public class ControllerBairroCidadeEstado {
    
    private Connection con;
    
    public ControllerBairroCidadeEstado(){
        this.con = ConexaoJdbc.getConexao();
    }
    
     public List select() {
         List<ModelBairroCidadeEstado> ListBaiCidEst = new ArrayList<ModelBairroCidadeEstado>();
         String sql="select \n" +"b.bairro_id,b.bairro_nome,c.cid_nome,e.estado_uf\n" +
                   "FROM "
                 + "tab_cadbairro b INNER JOIN tab_cadcidade c ON b.bairro_idcidade = c.cid_id "
                 + "INNER JOIN tab_estado e ON b.bairro_iduf = e.estado_id";
         
         PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table
            while (rs.next()) {
                ModelBairroCidadeEstado mBaCidEst = new ModelBairroCidadeEstado();
                //rs retorna todos os dados do banco de cada campo
                //para mcc que mostra na tabela
                mBaCidEst.setId(rs.getInt("b.bairro_id"));
                mBaCidEst.setBairro_nome(rs.getString("b.bairro_nome"));
                mBaCidEst.setCid_nome(rs.getString("c.cid_nome"));
                mBaCidEst.setUf(rs.getString("e.estado_uf"));

                ListBaiCidEst.add(mBaCidEst);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListBaiCidEst;
     }
    
}
