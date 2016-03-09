/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wellington
 */
public class ModelUsuarioPermissao {
   private int idusuariopermissao;
   private String fkusuarios;
   private String permissao;

    public int getIdusuariopermissao() {
        return idusuariopermissao;
    }

    public void setIdusuariopermissao(int idusuariopermissao) {
        this.idusuariopermissao = idusuariopermissao;
    }

    public String getFkusuarios() {
        return fkusuarios;
    }

    public void setFkusuarios(String fkusuarios) {
        this.fkusuarios = fkusuarios;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
   
   
   
}
