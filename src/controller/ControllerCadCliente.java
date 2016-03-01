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
import model.ModelCadCliente;
import conexao.ConexaoJdbc;
import util.InterfaceCrud;

public class ControllerCadCliente implements InterfaceCrud {

    private Connection con;

    //construto iciando atributo con com
    //a comunicação com o banco
    public ControllerCadCliente() {
        this.con = ConexaoJdbc.getConexao();
    }

    //metodo de insercao de dados no banco
    @Override
    public void insert(Object o) {
        //parametro 'o' repasando dados para mcadcliente em forma de cast
        //forçando sua conversao
        ModelCadCliente mCadCliente = (ModelCadCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "INSERT INTO  tab_cadcliente (cli_nome,cli_cpf,cli_email,cli_endereco,cli_numcasa,cli_complemento,cli_idbairro,cli_idcidade,cli_idestado,cli_cep,cli_telefone,cli_celular)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mCadCliente.getCli_nome());
            ps.setString(2, mCadCliente.getCli_cpf());
            ps.setString(3, mCadCliente.getCli_email());
            ps.setString(4, mCadCliente.getCli_endereco());
            ps.setString(5, mCadCliente.getCli_numcasa());
            ps.setString(6, mCadCliente.getCli_complemento());
            ps.setInt(7, mCadCliente.getCli_bairro());
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
        ModelCadCliente mCadCliente = (ModelCadCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "UPDATE tab_cadcliente set cli_nome = ?, cli_cpf = ?, cli_email = ?,cli_endereco = ?,cli_numcasa = ?, cli_complemento = ?,cli_idbairro = ?,cli_idcidade = ?,cli_idestado = ?,cli_cep = ?,cli_telefone = ?,cli_celular = ?"
                + " where cli_id = ? ";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, mCadCliente.getCli_nome());
            ps.setString(2, mCadCliente.getCli_cpf());
            ps.setString(3, mCadCliente.getCli_email());
            ps.setString(4, mCadCliente.getCli_endereco());
            ps.setString(5, mCadCliente.getCli_numcasa());
            ps.setString(6, mCadCliente.getCli_complemento());
            ps.setInt(7, mCadCliente.getCli_bairro());
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
        ModelCadCliente mCadCliente = (ModelCadCliente) o;
        //variavel sql recebe script de insercao de dados sql
        String sql = "delete from tab_cadcliente where cli_id = ?";

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
        ModelCadCliente mCadCliente = new ModelCadCliente();
        //scrip sql
        String sql = "select * from tab_cadCli where = ? ";
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
                mCadCliente.setCli_nome(rs.getString("cli_nome"));
                mCadCliente.setCli_cpf(rs.getString("cli_cpf"));
                mCadCliente.setCli_email(rs.getString("cli_email"));
                mCadCliente.setCli_endereco(rs.getString("cli_endereco"));
                mCadCliente.setCli_numcasa(rs.getString("cli_numcasa"));
                mCadCliente.setCli_complemento(rs.getString("cli_complemento"));
                mCadCliente.setCli_bairro(rs.getInt("cli_idbairro"));
                mCadCliente.setCli_idcidade(rs.getInt("cli_idCidade"));
                mCadCliente.setCli_idestado(rs.getInt("cli_idestado"));
                mCadCliente.setCli_cep(rs.getString("cli_cep"));
                mCadCliente.setCli_telefone(rs.getString("cli_telefone"));
                mCadCliente.setCli_celular(rs.getString("cli_celular"));
            }
        } catch (SQLException e) {

        }

        return mCadCliente;
    }

    @Override
    public List select() {
        List<ModelCadCliente> ListCadCliente = new ArrayList<ModelCadCliente>();
        String sql = "select * from tab_cadcliente";
        PreparedStatement ps;

        try {
            //ps recebe o codigo sql
            ps = this.con.prepareStatement(sql);
            //rs recebe a consulda no banco atraves do scrip sql retornando a consulta
            ResultSet rs = ps.executeQuery();
            // e equanto houver cadastro vai para o próximo
            //preenchendo a table do ViewCadCliente
            while (rs.next()) {
                ModelCadCliente mCadCliente = new ModelCadCliente();
                //rs retorna todos os dados do banco de cada campo
                //para mcc que mostra na tabela ViewCadCliente 
                mCadCliente.setCli_id(rs.getInt("cli_id"));
                mCadCliente.setCli_nome(rs.getString("cli_nome"));
                mCadCliente.setCli_cpf(rs.getString("cli_cpf"));
                mCadCliente.setCli_email(rs.getString("cli_email"));
                mCadCliente.setCli_endereco(rs.getString("cli_endereco"));
                mCadCliente.setCli_numcasa(rs.getString("cli_numcasa"));
                mCadCliente.setCli_complemento(rs.getString("cli_complemento"));
                mCadCliente.setCli_bairro(rs.getInt("cli_idbairro"));
                mCadCliente.setCli_idcidade(rs.getInt("cli_idCidade"));
                mCadCliente.setCli_idestado(rs.getInt("cli_idestado"));
                mCadCliente.setCli_cep(rs.getString("cli_cep"));
                mCadCliente.setCli_telefone(rs.getString("cli_telefone"));
                mCadCliente.setCli_celular(rs.getString("cli_celular"));

                ListCadCliente.add(mCadCliente);

            }
        } catch (SQLException e) {

        }
        // retonar os dados para preencher a tabela
        return ListCadCliente;
    }

}
