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
import model.ModelTipoPagamento;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerTipoPagamento implements InterfaceCrud {
    
    
    private Connection con;
    
    public ControllerTipoPagamento(){
        this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
        ModelTipoPagamento mtp = (ModelTipoPagamento) o;
        String sql = "INSERT INTO tipopagamento (nome) VALUES (?)";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mtp.getNome());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Foi Adcionado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao adiciona "+e);
        }
    }

    @Override
    public void update(Object o) {
        ModelTipoPagamento mtp = (ModelTipoPagamento) o;
        String sql = "UPDATE tipopagamento SET nome = ? where idtipopagamento = ?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mtp.getNome());
            ps.setInt(2, mtp.getIdtipopagamento());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Foi Atualizado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar editar "+e);
        }
    }

    @Override
    public void delete(Object o) {
        ModelTipoPagamento mtp = (ModelTipoPagamento) o;
        String sql = "DELETE FROM tipopagamento WHERE idtipoproduto = ? ";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, mtp.getIdtipopagamento());
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
        List<ModelTipoPagamento> mtp = new ArrayList<ModelTipoPagamento>();
        String sql = "select * from tipopagamento";
        PreparedStatement ps;

        try {

            ps = this.con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                ModelTipoPagamento m = new ModelTipoPagamento();
                m.setIdtipopagamento(rs.getInt("idtipopagamento"));
                m.setNome(rs.getString("nome"));

                mtp.add(m);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return mtp;
    }
    
    
}
