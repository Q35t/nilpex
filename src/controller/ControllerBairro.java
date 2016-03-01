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
import model.ModelBairro;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerBairro implements InterfaceCrud{
    
    private Connection con;
    private ModelBairro mCadBairro;
    
    public ControllerBairro(){
        this.con = ConexaoJdbc.getConexao();
        this.mCadBairro = new ModelBairro();
    }

    @Override
    public void insert(Object o) {
        this.mCadBairro = (ModelBairro) o;
        String sql="insert into tab_cadbairro (bairro_nome,bairro_idcidade,bairro_iduf) values (?,?,?)";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mCadBairro.getBairro_nome());
            ps.setInt(2, this.mCadBairro.getBairro_idcidade());
            ps.setInt(3, this.mCadBairro.getBairro_iduf());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o bairro!" + e);
            
        }
    }

    @Override
    public void update(Object o) {
        this.mCadBairro = (ModelBairro) o;
        String sql="update tab_cadbairro set bairro_nome = ?,bairro_idcidade = ?,bairro_iduf = ? where bairro_id=?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mCadBairro.getBairro_nome());
            ps.setInt(2, this.mCadBairro.getBairro_idcidade());
            ps.setInt(3, this.mCadBairro.getBairro_iduf());
            ps.setInt(4, this.mCadBairro.getBairro_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e); 
            
        }
    }

    @Override
    public void delete(Object o) {
        this.mCadBairro = (ModelBairro) o;
        String sql="delete from tab_cadbairro where bairro_id=?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, this.mCadBairro.getBairro_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "O bairro foi deletado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao deleta o bairro!");
        }
    }

    @Override
    public Object select(int i) {
        //estancia do modelo de cadastro de cidade
        this.mCadBairro = new ModelBairro();
        //scrip sql
        String sql = "select * from tab_cadcidade where = ? ";
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo da cidade passado por parametro em 'i'
            ps.setInt(1, i);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                // modelo de cadastro cidade recebe as informações 
                // do banco de dados para preencher JComboBox
                this.mCadBairro.setBairro_id(rs.getInt("bairro_id"));
                this.mCadBairro.setBairro_nome(rs.getString("bairro_nome"));
                this.mCadBairro.setBairro_idcidade(rs.getInt("bairro_idcidade"));
                this.mCadBairro.setBairro_iduf(rs.getInt("bairro_iduf"));
            }
        } catch (SQLException e) {

        }
        return this.mCadBairro;
    }

    @Override
    public List select() {
        List<ModelBairro> ListCadBairro = new ArrayList<ModelBairro>();
        String sql = "select * from tab_cadbairro";
        PreparedStatement ps;

        try {
            ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.mCadBairro = new ModelBairro();
                this.mCadBairro.setBairro_id(rs.getInt("bairro_id"));
                this.mCadBairro.setBairro_nome(rs.getString("bairro_nome"));
                this.mCadBairro.setBairro_idcidade(rs.getInt("bairro_idcidade"));
                this.mCadBairro.setBairro_iduf(rs.getInt("bairro_iduf"));
                ListCadBairro.add(this.mCadBairro);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCadBairro;
    }
    
    
}
