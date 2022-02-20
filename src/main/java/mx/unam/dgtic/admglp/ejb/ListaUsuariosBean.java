/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ListaUsuariosBean implements Serializable {
    
    private static final long serialVersionUID = -4146681491856848089L;
    List<UsuarioBean> usuarios;

    /**
     * Constructor
     */
    public ListaUsuariosBean() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new UsuarioBean("mike", "123"));
        usuarios.add(new UsuarioBean("pepe", "456"));
        usuarios.add(new UsuarioBean("dani", "789"));
    }

    public List<UsuarioBean> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioBean> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "ListaUsuariosBean{" + "usuarios=" + usuarios + '}';
    }

}
