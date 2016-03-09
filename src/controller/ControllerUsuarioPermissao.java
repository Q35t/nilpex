/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoJdbc;
import java.sql.Connection;
import java.util.List;
import model.ModelUsuarioPermissao;
import util.InterfaceCrud;

/**
 *
 * @author wellington
 */
public class ControllerUsuarioPermissao implements InterfaceCrud{
    
    private Connection con;
    
    public ControllerUsuarioPermissao(){
        this.con = ConexaoJdbc.getConexao();
    }

    @Override
    public void insert(Object o) {
        ModelUsuarioPermissao mup = (ModelUsuarioPermissao) o;
        String sql = "INSERT INTO usuario_permissao (fkusuarios,permissao) VALUES (?,?)";
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object select(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
