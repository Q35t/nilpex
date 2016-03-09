/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wellington
 */
import model.ModelCliente;
import conexao.ConexaoJdbc;
import util.InterfaceCrud;

public class ControllerCliente implements InterfaceCrud {

    private Connection con;

    //construto iciando atributo con com
    //a comunicação com o banco
    public ControllerCliente() {
        this.con = ConexaoJdbc.getConexao();
    }

    //metodo de insercao de dados no banco
    @Override
    public void insert(Object o) {
        //parametro 'o' repasando dados para mcadcliente em forma de cast
        //forçando sua conversao
        ModelCliente mCadCliente = (ModelCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "INSERT INTO  clientes (nome,cpf,email,endereco,numcasa,complemento,bairro,fkcidade,fkestado,cep,telefone,celular)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mCadCliente.getCli_nome());
            ps.setString(2, mCadCliente.getCli_cpf());
            ps.setString(3, mCadCliente.getCli_email());
            ps.setString(4, mCadCliente.getCli_endereco());
            ps.setString(5, mCadCliente.getCli_numcasa());
            ps.setString(6, mCadCliente.getCli_complemento());
            ps.setString(7, mCadCliente.getCli_bairro());
            ps.setInt(8, mCadCliente.getCli_idcidade());
            ps.setInt(9, mCadCliente.getCli_idestado());
            ps.setString(10, mCadCliente.getCli_cep());
            ps.setString(11, mCadCliente.getCli_telefone());
            ps.setString(12, mCadCliente.getCli_celular());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o cliente!" + e);
        }

    }

    @Override
    public void update(Object o) {

        //parametro 'o' repasando dados para mcadcliente em forma de cast
        //forçando sua conversao
        ModelCliente mCadCliente = (ModelCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "UPDATE clientes set nome = ?, cpf = ?, email = ?,endereco = ?,numcasa = ?, complemento = ?,bairro = ?,fkcidade = ?,fkestado = ?,cep = ?,telefone = ?,celular = ?"
                + " where idclientes = ? ";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mCadCliente.getCli_nome());
            ps.setString(2, mCadCliente.getCli_cpf());
            ps.setString(3, mCadCliente.getCli_email());
            ps.setString(4, mCadCliente.getCli_endereco());
            ps.setString(5, mCadCliente.getCli_numcasa());
            ps.setString(6, mCadCliente.getCli_complemento());
            ps.setString(7, mCadCliente.getCli_bairro());
            ps.setInt(8, mCadCliente.getCli_idcidade());
            ps.setInt(9, mCadCliente.getCli_idestado());
            ps.setString(10, mCadCliente.getCli_cep());
            ps.setString(11, mCadCliente.getCli_telefone());
            ps.setString(12, mCadCliente.getCli_celular());
            ps.setInt(13, mCadCliente.getCli_id());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Os dados foram atualizado!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar os dados!" + e);
        }

    }

    @Override
    public void delete(Object o) {
        //parametro 'o' repasando dados para mcadcliente em forma de cast
        //forçando sua conversao
        ModelCliente mCadCliente = (ModelCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "delete from clientes where idclientes = ?";

        try {
            //ps recebe o scrip sql para deleta o usuario que tiver o codigo
            //que esta sendo repassado para ps.setInt
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, mCadCliente.getCli_id());
            //ps.execute excuta o codigo de exclusao
            ps.execute();

            JOptionPane.showMessageDialog(null, "O cliente foi deletado!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao deleta o cliente!");
        }
    }

    @Override
    public Object select(int i) {
        //estacia do modelo de cadastro de cliente
        ModelCliente mCadCliente = new ModelCliente();
        //scrip sql
        String sql = "select * from clintes where idclientes = ? ";
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
                // modelo de cadastro cliente recebe as informações 
                // do banco de dados para preencher JComboBox
                mCadCliente.setCli_nome(rs.getString("nome"));
                mCadCliente.setCli_cpf(rs.getString("cpf"));
                mCadCliente.setCli_email(rs.getString("email"));
                mCadCliente.setCli_endereco(rs.getString("endereco"));
                mCadCliente.setCli_numcasa(rs.getString("numcasa"));
                mCadCliente.setCli_complemento(rs.getString("complemento"));
                mCadCliente.setCli_bairro(rs.getString("bairro"));
                mCadCliente.setCli_idcidade(rs.getInt("fkCidade"));
                mCadCliente.setCli_idestado(rs.getInt("fkestado"));
                mCadCliente.setCli_cep(rs.getString("cep"));
                mCadCliente.setCli_telefone(rs.getString("telefone"));
                mCadCliente.setCli_celular(rs.getString("celular"));
            }
        } catch (SQLException e) {

        }

        return mCadCliente;
    }
    
    public Object select(String nome) {
        //estacia do modelo de cadastro de cliente
        ModelCliente mCadCliente = new ModelCliente();
        //scrip sql
        String sql = "select * from clientes where nome = ? ";
        PreparedStatement ps;

        try {
            //ps recebe o scrip sql
            ps = this.con.prepareStatement(sql);
            //ps recebe o codigo do clinte passado por parametro em 'i'
            ps.setString (1, nome);
            //rs recebe o resultado da consulta atraves do executeQuery
            ResultSet rs = ps.executeQuery();
            //e enquanto o rs retorna dados verdadeiros TRUE
            //avança para o próximo
            while (rs.next()) {
                // modelo de cadastro cliente recebe as informações 
                // do banco de dados para preencher JComboBox
                mCadCliente.setCli_nome(rs.getString("nome"));
                mCadCliente.setCli_cpf(rs.getString("cpf"));
                mCadCliente.setCli_email(rs.getString("email"));
                mCadCliente.setCli_endereco(rs.getString("endereco"));
                mCadCliente.setCli_numcasa(rs.getString("numcasa"));
                mCadCliente.setCli_complemento(rs.getString("complemento"));
                mCadCliente.setCli_bairro(rs.getString("bairro"));
                mCadCliente.setCli_idcidade(rs.getInt("fkCidade"));
                mCadCliente.setCli_idestado(rs.getInt("fkestado"));
                mCadCliente.setCli_cep(rs.getString("cep"));
                mCadCliente.setCli_telefone(rs.getString("telefone"));
                mCadCliente.setCli_celular(rs.getString("celular"));
            }
        } catch (SQLException e) {

        }

        return mCadCliente;
    }


    @Override
    public List select() {
        List<ModelCliente> ListCadCliente = new ArrayList<ModelCliente>();
        String sql = "select * from clientes";
        PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table do ViewCadCliente
            while (rs.next()) {
                ModelCliente mCadCliente = new ModelCliente();
                //rs retorna todos os dados do banco de cada campo
                //para mcc que mostra na tabela ViewCadCliente 
                mCadCliente.setCli_id(rs.getInt("idclientes"));
                mCadCliente.setCli_nome(rs.getString("nome"));
                mCadCliente.setCli_cpf(rs.getString("cpf"));
                mCadCliente.setCli_email(rs.getString("email"));
                mCadCliente.setCli_endereco(rs.getString("endereco"));
                mCadCliente.setCli_numcasa(rs.getString("numcasa"));
                mCadCliente.setCli_complemento(rs.getString("complemento"));
                mCadCliente.setCli_bairro(rs.getString("bairro"));
                mCadCliente.setCli_idcidade(rs.getInt("fkCidade"));
                mCadCliente.setCli_idestado(rs.getInt("fkestado"));
                mCadCliente.setCli_cep(rs.getString("cep"));
                mCadCliente.setCli_telefone(rs.getString("telefone"));
                mCadCliente.setCli_celular(rs.getString("celular"));

                ListCadCliente.add(mCadCliente);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCadCliente;
    }

}
