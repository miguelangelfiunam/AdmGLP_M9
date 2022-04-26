package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Interfaz de servicio para consulta de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface UsuarioService {

    public Exception getError();

    public List<Usuario> getUsuarios();
    
    public List<Usuario> getUsuarios(Integer estatus);

    public Usuario getUsuario(int idusuario);
    
    public Usuario getUsuario(String apodo, String contra, Integer estatus);
    
    public Usuario deleteUsuario(int idusuario);
    
    public Usuario updateUsuario(Usuario usuario);
    
    public Usuario insertUsuario(Usuario usuario);
    
}
