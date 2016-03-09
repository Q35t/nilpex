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
      String sql = "select p.idprodutos, p.nome, p.valor, p.quant,f.nome\n" +
      "FROM produtos p INNER JOIN fornecedores f ON p.fkfornecedor = f.idfornecedores";
      
      try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                ModeloProdutoFornecedor mProFor = new ModeloProdutoFornecedor();
                
                mProFor.setPro_id(rs.getInt("p.idprodutos"));
                mProFor.setPro_nome(rs.getString("p.nome"));
                mProFor.setPro_valor(rs.getDouble("p.valor"));
                mProFor.setPro_quant(rs.getInt("p.quant"));
                mProFor.setPro_fornecedor(rs.getString("f.nome"));
                
                ListProFor.add(mProFor);
            }
          
        }
        catch(SQLException e){
          
        }
      
        
        return ListProFor;
    }
    
}
