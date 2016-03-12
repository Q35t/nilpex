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
import model.ModelFornecedor;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerFornecedor implements InterfaceCrud {
    
    private Connection con;
    private ModelFornecedor mCadFornecedor;
    
    public ControllerFornecedor(){
        
        this.con = ConexaoJdbc.getConexao();
        this.mCadFornecedor = new ModelFornecedor();
    }
    
    @Override
    public void insert(Object o) {
       this.mCadFornecedor = (ModelFornecedor) o;
       String sql = "insert into fornecedores (nome,cpf,email,endereco,num,complemento,bairro,fkcidade,cep,telefone,telcomercial) values"
               + "(?,?,?,?,?,?,?,?,?,?,?)";
       
       try{
           PreparedStatement ps = this.con.prepareStatement(sql);
           ps.setString(1, this.mCadFornecedor.getFor_nome() );
           ps.setString(2, this.mCadFornecedor.getFor_cnpj_cpf());
           ps.setString(3, this.mCadFornecedor.getFor_email());
           ps.setString(4, this.mCadFornecedor.getFor_endereco());
           ps.setString(5, this.mCadFornecedor.getFor_num());
           ps.setString(6, this.mCadFornecedor.getFor_complemento());
           ps.setString(7, this.mCadFornecedor.getFor_bairro());
           ps.setInt(8, this.mCadFornecedor.getFor_idcidade());
           ps.setString(9,this.mCadFornecedor.getFor_cep() );
           ps.setString(10,this.mCadFornecedor.getFor_telefone() );
           ps.setString(11, this.mCadFornecedor.getFor_telcomercial());
           ps.execute();
           JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
           
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o cliente!" + e);
       }
    }

    @Override
    public void update(Object o) {
       this.mCadFornecedor = (ModelFornecedor) o;
       String sql = "update fornecedores set nome = ?,cpf = ? ,email = ?,endereco = ?,num = ?,complemento = ?, bairro = ?,fkcidade = ?,cep = ?,telefone = ?,telcomercial = ? where idfornecedores=?";
       
       try{
           PreparedStatement ps = this.con.prepareStatement(sql);
           ps.setString(1, this.mCadFornecedor.getFor_nome() );
           ps.setString(2, this.mCadFornecedor.getFor_cnpj_cpf());
           ps.setString(3, this.mCadFornecedor.getFor_email());
           ps.setString(4, this.mCadFornecedor.getFor_endereco());
           ps.setString(5, this.mCadFornecedor.getFor_num());
           ps.setString(6, this.mCadFornecedor.getFor_complemento());
           ps.setString(7, this.mCadFornecedor.getFor_bairro());
           ps.setInt(8, this.mCadFornecedor.getFor_idcidade());
           ps.setString(9,this.mCadFornecedor.getFor_cep() );
           ps.setString(10,this.mCadFornecedor.getFor_telefone() );
           ps.setString(11, this.mCadFornecedor.getFor_telcomercial());
           ps.setInt(12, this.mCadFornecedor.getFor_id());
           ps.execute();
           JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");;
           
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e);
       }
    }

    @Override
    public void delete(Object o) {
      this.mCadFornecedor = (ModelFornecedor) o;
       String sql = "delete from fornecedores where idfornecedores = ?";
       
       try{
           PreparedStatement ps = this.con.prepareStatement(sql);
           ps.setInt(1, this.mCadFornecedor.getFor_id());
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "O Fornecedor foi deletado!");
       }
       catch(SQLException e){
           
           JOptionPane.showMessageDialog(null, "Houve um erro ao deleta o cliente!");
       }
    }

    @Override
    public Object select(int i) {
      
        String sql = "select * from fornecedores where idfornecedores= ? ";
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo do clinte passado por parametro em 'i'
            ps.setInt(1, i);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                
                // do banco de dados para preencher JComboBox
                this.mCadFornecedor.setFor_nome(rs.getString("nome"));
                this.mCadFornecedor.setFor_cnpj_cpf(rs.getString("cpf"));
                this.mCadFornecedor.setFor_email(rs.getString("email"));
                this.mCadFornecedor.setFor_endereco(rs.getString("endereco"));
                this.mCadFornecedor.setFor_num(rs.getString("num"));
                this.mCadFornecedor.setFor_complemento(rs.getString("complemento"));
                this.mCadFornecedor.setFor_bairro(rs.getString("bairro"));
                this.mCadFornecedor.setFor_idcidade(rs.getInt("fkCidade"));
                this.mCadFornecedor.setFor_cep(rs.getString("cep"));
                this.mCadFornecedor.setFor_telefone(rs.getString("telefone"));
                this.mCadFornecedor.setFor_telcomercial(rs.getString("celular"));
            }
        } catch (SQLException e) {

        }

        return this.mCadFornecedor;
    }
    
     public int select(String nome) {
      
        String sql = "select * from fornecedores where nome = ? ";
        PreparedStatement ps;
        int codigo = 0;
        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo do clinte passado por parametro em 'i'
            ps.setString(1, nome);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                codigo = rs.getInt("idfornecedores");
                // do banco de dados para preencher JComboBox
                //this.mCadFornecedor.setFor_nome(rs.getString("for_nome"));
                //this.mCadFornecedor.setFor_cnpj_cpf(rs.getString("for_cnpj_cpf"));
                //this.mCadFornecedor.setFor_email(rs.getString("for_email"));
                //this.mCadFornecedor.setFor_endereco(rs.getString("for_endereco"));
                //this.mCadFornecedor.setFor_num(rs.getString("for_numcasa"));
                //this.mCadFornecedor.setFor_complemento(rs.getString("for_complemento"));
                //this.mCadFornecedor.setFor_bairro(rs.getString("for_bairro"));
                //this.mCadFornecedor.setFor_idcidade(rs.getInt("for_idCidade"));
                //this.mCadFornecedor.setFor_idestado(rs.getInt("for_idestado"));
                //this.mCadFornecedor.setFor_cep(rs.getString("for_cep"));
                //this.mCadFornecedor.setFor_telefone(rs.getString("for_telefone"));
                //this.mCadFornecedor.setFor_telcomercial(rs.getString("for_celular"));
            }
        } catch (SQLException e) {

        }

        return codigo;
    }

    @Override
    public List select() {
         List<ModelFornecedor> ListCadFornecedor = new ArrayList<ModelFornecedor>();
        String sql = "select * from fornecedores";
        PreparedStatement ps;

        try {
            
            ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ModelFornecedor mFor = new ModelFornecedor();
                mFor.setFor_nome(rs.getString("nome"));
                mFor.setFor_cnpj_cpf(rs.getString("cpf"));
                mFor.setFor_email(rs.getString("email"));
                mFor.setFor_endereco(rs.getString("endereco"));
                mFor.setFor_num(rs.getString("num"));
                mFor.setFor_complemento(rs.getString("complemento"));
                mFor.setFor_bairro(rs.getString("bairro"));
                mFor.setFor_idcidade(rs.getInt("fkCidade"));
                mFor.setFor_cep(rs.getString("cep"));
                mFor.setFor_telefone(rs.getString("telefone"));
                mFor.setFor_telcomercial(rs.getString("telcomercial"));

                ListCadFornecedor.add(mFor);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCadFornecedor;
    }
        
}
