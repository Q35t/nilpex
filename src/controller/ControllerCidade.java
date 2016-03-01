/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoJdbc;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.ModelCidade;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerCidade implements InterfaceCrud{
    
    private ModelCidade mCadCidade;
    private Connection con;
    
    public ControllerCidade(){
       this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
       this.mCadCidade = (ModelCidade) o;
       String sql = "INSERT INTO tab_cadcidade (cid_nome,cid_idestado) VALUES (?,?)";
       try{
           PreparedStatement ps = this.con.prepareStatement(sql);
           System.out.println(this.mCadCidade.getCid_nome());
           System.out.print(this.mCadCidade.getCid_idestado());
           ps.setString(1, this.mCadCidade.getCid_nome());
           ps.setInt(2, this.mCadCidade.getCid_idestado());
           ps.execute();
           JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar a cidade!" + e);
       }
    }

    @Override
    public void update(Object o) {
        this.mCadCidade = (ModelCidade) o;
        String sql = "update tab_cadcidade set cid_nome = ?, cid_idestado= ? where cid_id = ? ";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mCadCidade.getCid_nome());
            ps.setInt(2, this.mCadCidade.getCid_idestado());
            ps.setInt(3, this.mCadCidade.getCid_id());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");
            
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e);
            
        }
    }

    @Override
    public void delete(Object o) {
        this.mCadCidade = (ModelCidade) o;
        String sql = "delete from tab_cadcidade where cid_id = ?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, this.mCadCidade.getCid_id());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "A cidade foi deletado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao deleta a cidade!");
        }
    }

    @Override
    public Object select(int i) {
        //estancia do modelo de cadastro de cidade
        this.mCadCidade = new ModelCidade();
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
                this.mCadCidade.setCid_id(rs.getInt("cid_id"));
                this.mCadCidade.setCid_nome(rs.getString("cid_nome"));
                this.mCadCidade.setCid_idestado(rs.getInt("cid_idestado"));
            }
        } catch (SQLException e) {

        }
        
        return this.mCadCidade;
    }

    @Override
    public List select() {
        List<ModelCidade> ListCadCidade = new ArrayList<ModelCidade>();
        String sql = "select * from tab_cadcidade";
        PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table do ViewCadCidade
            while (rs.next()) {
                this.mCadCidade = new ModelCidade();
                //rs retorna todos os dados do banco de cada campo
                //para mCadCidade que mostra na tabela ViewCadCidade
                this.mCadCidade.setCid_id(rs.getInt("cid_id"));
                this.mCadCidade.setCid_nome(rs.getString("cid_nome"));
                this.mCadCidade.setCid_idestado(rs.getInt("cid_idestado"));

                ListCadCidade.add(this.mCadCidade);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCadCidade;
    }
    
}
