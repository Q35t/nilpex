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
import model.ModelProduto;
import model.ModeloProdutoFornecedor;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerProduto implements InterfaceCrud {
    
    private Connection con;
    private ModelProduto mPro;
    
    public ControllerProduto(){
        this.con = ConexaoJdbc.getConexao();
        this.mPro = new ModelProduto();
    }

    @Override
    public void insert(Object o) {
        this.mPro = (ModelProduto) o;
        String sql = "insert into produtos (nome,valor,quant,foto,fkfornecedor) values (?,?,?,?,?)";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mPro.getPro_nome());
            ps.setDouble(2, this.mPro.getPro_valor());
            ps.setInt(3, this.mPro.getPro_estoq());
            ps.setBytes(4, this.mPro.getPro_imagen());
            ps.setInt(5, this.mPro.getPro_idfornecedor());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o bairro!" + e);
        }
    }

    @Override
    public void update(Object o) {
        this.mPro = (ModelProduto) o;
        String sql = "update produtos set nome = ?,valor = ?,quant = ?,foto = ?,fkfornecedor = ? where idprodutos=?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mPro.getPro_nome());
            ps.setDouble(2, this.mPro.getPro_valor());
            ps.setInt(3, this.mPro.getPro_estoq());
            ps.setBytes(4, this.mPro.getPro_imagen());
            ps.setInt(5, this.mPro.getPro_idfornecedor());
            ps.setInt(6, this.mPro.getPro_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e); 
        }
    }

    @Override
    public void delete(Object o) {
        this.mPro = (ModelProduto) o;
        String sql = "delete from produtos where idprodutos = ?"; 
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, this.mPro.getPro_id());
            ps.execute();
             JOptionPane.showMessageDialog(null, "O produto foi deletado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao deleta o produto!"); 
        }
   }

    @Override
    public Object select(int i) {
        this.mPro = new ModelProduto();
        String sql = "select * from produtos where idprodutos = ?"; 
        
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.mPro.setPro_id(rs.getInt("idprodutos"));
                this.mPro.setPro_nome(rs.getString("nome"));
                this.mPro.setPro_valor(rs.getDouble("valor"));
                this.mPro.setPro_estoq(rs.getInt("quant"));
                this.mPro.setPro_imagen(rs.getBytes("foto"));
                this.mPro.setPro_idfornecedor(rs.getInt("fkfornecedor"));
            }
        } catch (SQLException e) {

        }
        return this.mPro;
    }
    
    public Object select(String nome) {
        this.mPro = new ModelProduto();
        String sql = "select * from produtos where nome = ?"; 
        
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.mPro.setPro_id(rs.getInt("idprodutos"));
                this.mPro.setPro_nome(rs.getString("nome"));
                this.mPro.setPro_valor(rs.getDouble("valor"));
                this.mPro.setPro_imagen(rs.getBytes("foto"));
            }
        } catch (SQLException e) {

        }
        return this.mPro;
    }

    @Override
    public List select() {
        List<ModelProduto> ListPro = new ArrayList<ModelProduto>();

        String sql = "select * from produtos"; 
        
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelProduto p = new ModelProduto();
                p.setPro_id(rs.getInt("idprodutos"));
                p.setPro_nome(rs.getString("nome"));
                p.setPro_valor(rs.getDouble("valor"));
                p.setPro_estoq(rs.getInt("quant"));
                p.setPro_imagen(rs.getBytes("foto"));
                p.setPro_idfornecedor(rs.getInt("fkfornecedor"));
                ListPro.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados "+e);
        }
        return ListPro;
    }
    
   
}
