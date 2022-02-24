/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.model.RolModel;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ListaRolesBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    List<RolModel> rolModels;

    public ListaRolesBean() {
        this.rolModels = new ArrayList<>();
        rolModels.add(new RolModel(1, "Administrador", "A", new Date(), null, 10));
        rolModels.add(new RolModel(1, "Empleado", "E", new Date(), null, 10));
        rolModels.add(new RolModel(1, "Cliente", "C", new Date(), null, 10));
    }

    public List<RolModel> getRolModels() {
        return rolModels;
    }

    public void setRolModels(List<RolModel> rolModels) {
        this.rolModels = rolModels;
    }

    @Override
    public String toString() {
        return "ListaRolesBean{" + "rolModels=" + rolModels + '}';
    }
}
