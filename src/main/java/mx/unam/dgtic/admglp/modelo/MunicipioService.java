package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 * Interfaz para CRUD de municipios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface MunicipioService {

    public Exception getError();

    public List<Municipio> getMunicipios();

    public List<Municipio> getMunicipios(Integer estatus);

    public List<Municipio> getMunicipiosPorIdEstado(Integer idEstado, Integer estatus_municipio);

    public Municipio getMunicipio(int idMunicipio);

    public Municipio deleteMunicipio(int idMunicipio);

    public Municipio updateMunicipio(Municipio municipio);

    public Municipio insertMunicipio(Municipio municipio);

}
