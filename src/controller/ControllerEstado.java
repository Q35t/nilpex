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
import model.ModelEstado;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerEstado implements InterfaceCrud{
    
    private Connection con;
    private ModelEstado mEstado;
    
    public ControllerEstado(){
        this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
        this.mEstado = (ModelEstado) o;
        String sql = "insert into estados (uf,nome) values (?,?)";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mEstado.getEstado_uf());
            ps.setString(2, this.mEstado.getEstado_nome());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o estado!" + e);
        }
    }

    @Override
    public void update(Object o) {
        this.mEstado = (ModelEstado) o;
        String sql = "update estados set uf = ?, nome = ? where idestados = ? ";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, this.mEstado.getEstado_uf());
            ps.setString(2, this.mEstado.getEstado_nome());
            ps.setInt(3, this.mEstado.getEstado_id());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");
            
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e);
            
        }
    }

    @Override
    public void delete(Object o) {
        this.mEstado = (ModelEstado) o;
        String sql = "delete from estados where idestados = ?";
        
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, this.mEstado.getEstado_id());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "O estado foi deletado!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Houve um erro ao deleta o estado!");
        }
    }

    @Override
    public Object select(int i) {
        //estancia do modelo de estado
        this.mEstado = new ModelEstado();
        //scrip sql
        String sql = "select * from estados where idestados = ? ";
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo dos estado passado por parametro em 'i'
            ps.setInt(1, i);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                // modelo de estado recebe as informações 
                // do banco de dados para preencher JComboBox
                this.mEstado.setEstado_id(rs.getInt("idestados"));
                this.mEstado.setEstado_uf(rs.getString("uf"));
                this.mEstado.setEstado_nome(rs.getString("nome"));
            }
        } catch (SQLException e) {

        }
        
        return this.mEstado;
    }
    
    public int select(String nome) {
        //estancia do modelo de estado
        this.mEstado = new ModelEstado();
        //scrip sql
        String sql = "select * from estados where uf = ? ";
        PreparedStatement ps;
        int codigo = 0;
        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo dos estado passado por parametro em 'i'
            ps.setString(1, nome);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                // modelo de estado recebe as informações 
                // do banco de dados para preencher JComboBox
                codigo = rs.getInt("idestados");
                //this.mEstado.setEstado_id(rs.getInt("estado_id"));
                //this.mEstado.setEstado_uf(rs.getString("estado_uf"));
                //this.mEstado.setEstado_nome(rs.getString("estado_nome"));
            }
        } catch (SQLException e) {

        }
        
        return codigo;
    }

    @Override
    public List select() {
        List <ModelEstado> ListEstado = new ArrayList<ModelEstado>();
        String sql = "select * from estados";
        PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table
            while (rs.next()) {
                this.mEstado = new ModelEstado();
                //rs retorna todos os dados do banco de cada campo
                //para mEstado que mostra na tabela
                this.mEstado.setEstado_id(rs.getInt("idestados"));
                this.mEstado.setEstado_uf(rs.getString("uf"));
                this.mEstado.setEstado_nome(rs.getString("nome"));

                ListEstado.add(this.mEstado);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListEstado;
    }


}
