package mx.unam.dgtic.admglp.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;


/**
 *
 * @author unam
 */
@ManagedBean
@RequestScoped
public class AppController {
    private String version;
    private String servidor;
    private String proyecto;
    private String autor;
    private String modulo;
    
    @PostConstruct
    public void init(){
        version = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("version");
        servidor = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("servidor");
        proyecto = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("proyecto");
        autor = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("autor");
        modulo = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("modulo");
        System.out.println(this);
    }

    public String getVersion() {
        return version;
    }

    public String getServidor() {
        return servidor;
    }

    public String getProyecto() {
        return proyecto;
    }

    public String getAutor() {
        return autor;
    }

    public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

}
