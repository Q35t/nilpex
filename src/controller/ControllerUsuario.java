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
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelUsuario;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerUsuario implements InterfaceCrud {
    
    private Connection con;
    
    public ControllerUsuario(){
        this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
        ModelUsuario u = (ModelUsuario) o;
        String sql = "INSERT INTO usuarios (nome,login,senha,fktipousuario)  VALUES (?,?,?,?)";
        
        PreparedStatement ps;
        try{
            ps = this.con.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getSenhas());
            ps.setInt(4, u.getFktipousuario());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar o cadastro!, Erro +"+e);
        }
    }

    @Override
    public void update(Object o) {
       ModelUsuario u = (ModelUsuario) o;
       String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, fktipousuario = ? WHERE idusuarios = ? ";
       
       
        PreparedStatement ps;
        try{
            ps = this.con.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getSenhas());
            ps.setInt(4, u.getFktipousuario());
            ps.setInt(5, u.getIdusuarios());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Atualização realizado com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi possivel Atualizar os dados!, Erro +"+e);
        }
    }

    @Override
    public void delete(Object o) {
        ModelUsuario u = (ModelUsuario) o;
       String sql = "DELETE FROM usuarios WHERE idusuarios = ? ";
       
       
        PreparedStatement ps;
        try{
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, u.getIdusuarios());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Usuario deletado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi possivel deleta o usuario!, Erro +"+e);
        }
    }

    @Override
    public Object select(int i) {
       ModelUsuario u = new ModelUsuario();
       String sql = "SELECT * FROM usuarios WHERE idusuarios = ?";
       
       try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                u.setIdusuarios(rs.getInt("idusuarios"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenhas(rs.getString("senha"));
                u.setFktipousuario(rs.getInt("fktipousuario"));
             }
       }
       catch(SQLException e){
           
       }
       
       return u;
    }
    
     public ModelUsuario select(String nome) {
       ModelUsuario u = new ModelUsuario();
       String sql = "SELECT * FROM usuarios WHERE login = ?";
       
       try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                u.setIdusuarios(rs.getInt("idusuarios"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenhas(rs.getString("senha"));
                u.setFktipousuario(rs.getInt("fktipousuario"));
             }
       }
       catch(SQLException e){
           
       }
       
       return u;
    }
    
    public boolean select(String login, String senha){
        ModelUsuario u = new ModelUsuario();
        String sql = "SELECT * FROM usuarios WHERE login = ? and senha = ?";
        boolean retorno = false;
        
            try{
                PreparedStatement ps = this.con.prepareStatement(sql);
                ps.setString(1, login);
                ps.setString(2, senha);
                ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        if(rs.getString("login").equals(login) && rs.getString("senha").equals(senha) ){
                            retorno = true;
                        }
                        else{
                            retorno = false;
                        }
                    }
            }
            catch(SQLException e){
                
            }
            
            return retorno;
    }

    @Override
    public List select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
