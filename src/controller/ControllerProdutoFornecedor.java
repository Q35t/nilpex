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
import model.ModeloProdutoFornecedor;

/**
 *
 * @author wellington
 */
public class ControllerProdutoFornecedor {
    
    private Connection con;
    
    public ControllerProdutoFornecedor(){
        this.con = ConexaoJdbc.getConexao();
    }
    
    public Object select(){
      List<ModeloProdutoFornecedor> ListProFor = new ArrayList<ModeloProdutoFornecedor>(); 
      String sql = "select p.pro_id, p.pro_nome, p.pro_valor, p.pro_quant,f.for_nome\n" +
      "FROM tab_cadproduto p INNER JOIN tab_cadfornecedor f ON p.pro_idfornecedor = f.for_id";
      
      try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                ModeloProdutoFornecedor mProFor = new ModeloProdutoFornecedor();
                
                mProFor.setPro_id(rs.getInt("p.pro_id"));
                mProFor.setPro_nome(rs.getString("p.pro_nome"));
                mProFor.setPro_valor(rs.getDouble("p.pro_valor"));
                mProFor.setPro_quant(rs.getInt("p.pro_quant"));
                mProFor.setPro_fornecedor("f.for_nome");
                
                ListProFor.add(mProFor);
            }
          
      }
      catch(SQLException e){
          
      }
      
        
        return ListProFor;
    }
    
}
