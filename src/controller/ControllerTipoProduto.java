/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoJdbc;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelTipoProduto;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerTipoProduto implements InterfaceCrud {
    
    private Connection con;
    
    public ControllerTipoProduto(){
        this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
        ModelTipoProduto mtp = (ModelTipoProduto) o;
        String sql = "INSERT INTO tipoproduto (nome) VALUES (?)";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mtp.getTipo_nome());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Foi Adcionado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao adiciona "+e);
        }
        
    }

    @Override
    public void update(Object o) {
        ModelTipoProduto mtp = (ModelTipoProduto) o;
        String sql = "UPDATE tipoproduto SET nome = ? where idtipoproduto = ?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mtp.getTipo_nome());
            ps.setInt(2, mtp.getTipo_id());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Foi Atualizado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar editar "+e);
        }
    }

    @Override
    public void delete(Object o) {
        ModelTipoProduto mtp = (ModelTipoProduto) o;
        String sql = "DELETE FROM tipoproduto WHERE idtipoproduto = ? ";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, mtp.getTipo_id());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Foi Deletado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Deletar"+e);
        }
        
    }

    @Override
    public Object select(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List select() {
        List<ModelTipoProduto> mtp = new ArrayList<ModelTipoProduto>();
        
        String sql = "select * from tipoproduto";
        PreparedStatement ps;

        try {

            ps = this.con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                ModelTipoProduto m = new ModelTipoProduto();
                m.setTipo_id(rs.getInt("idtipoprodutos"));
                m.setTipo_nome(rs.getString("nome"));

                mtp.add(m);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return mtp;
    }
    
}
