package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mx.unam.dgtic.admglp.model.ContraModel;
import mx.unam.dgtic.admglp.model.RolModel;
import mx.unam.dgtic.admglp.model.UsuarioModel;
import mx.unam.dgtic.admglp.model.Usuario_rolModel;

@Named
@SessionScoped
public class ListaUsuariosBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    List<UsuarioModel> usuarioModels;

    @Inject
    ListaRolesBean listaRolesBean;

    @Inject
    ListaContrasBean listaContrasBean;

    /**
     * Constructor
     */
    public ListaUsuariosBean() {
        this.usuarioModels = new ArrayList<>();

        List<Usuario_rolModel> lista_1 = new ArrayList<>();
        ContraModel contraModel_1 = new ContraModel(1, "123", new Date(), null, 10);
        UsuarioModel usuario_1 = new UsuarioModel(1, "mike", "miguelangel@dgp.unam.mx", null, "Miguel", "Martinez",
                "Rivera", 28, new Date(), "5534385266", null, new Date(), null, 10);
        RolModel rolModel_1 = new RolModel(1, "Administrador", "A", new Date(), null, 10);
        lista_1.add(new Usuario_rolModel(1, rolModel_1, usuario_1, new Date(), null, 10));
        usuario_1.setContra(contraModel_1);
        usuario_1.setUsuario_rolModels(lista_1);
        usuarioModels.add(usuario_1);

        List<Usuario_rolModel> lista_2 = new ArrayList<>();
        ContraModel contraModel_2 = new ContraModel(2, "456", new Date(), null, 10);
        RolModel rolModel_2 = new RolModel(2, "Empleado", "E", new Date(), null, 10);
        UsuarioModel usuario_2 = new UsuarioModel(2, "ingrid", "ingrid@dgp.unam.mx", null, "Ingrid", "Garrido",
                "Gonzalez", 28, new Date(), "5512345678", null, new Date(), null, 10);
        lista_2.add(new Usuario_rolModel(2, rolModel_2, usuario_2, new Date(), null, 10));
        usuario_2.setContra(contraModel_2);
        usuario_2.setUsuario_rolModels(lista_2);
        usuarioModels.add(usuario_2);

        List<Usuario_rolModel> lista_3 = new ArrayList<>();
        ContraModel contraModel_3 = new ContraModel(3, "789", new Date(), null, 10);
        RolModel rolModel_3 = new RolModel(3, "Cliente", "C", new Date(), null, 10);
        UsuarioModel usuario_3 = new UsuarioModel(3, "pascual", "pascual@dgp.unam.mx", null, "Pascual", "Martinez",
                "Resendiz", 60, new Date(), "5587654321", null, new Date(), null, 10);
        lista_3.add(new Usuario_rolModel(3, rolModel_3, usuario_3, new Date(), null, 10));
        usuario_3.setContra(contraModel_3);
        usuario_3.setUsuario_rolModels(lista_3);
        usuarioModels.add(usuario_3);

    }

    public List<UsuarioModel> getUsuarioModels() {
        return usuarioModels;
    }

    public void setUsuarioModels(List<UsuarioModel> usuarioModels) {
        this.usuarioModels = usuarioModels;
    }

    @Override
    public String toString() {
        return "ListaUsuariosBean{" + "usuarioModels=" + usuarioModels + '}';
    }

}
