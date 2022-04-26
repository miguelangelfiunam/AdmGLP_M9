package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 * Interfaz de servicio para consulta de articulos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 16/04/2022 - 26/04/2022
 *
 */
public interface ArticuloService {

    public Exception getError();

    public List<Articulo> getArticulos();
    
    public List<Articulo> getArticulos(Integer estatus);

    public Articulo getArticulo(int idarticulo);
    
    public Articulo deleteArticulo(int idarticulo);
    
    public Articulo updateArticulo(Articulo articulo);
    
    public Articulo insertArticulo(Articulo articulo);
    
}
