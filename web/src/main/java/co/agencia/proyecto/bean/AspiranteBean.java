package co.agencia.proyecto.bean;

import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.servicios.AspiranteServicio;
import co.agencia.proyecto.servicios.ProfesionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */

@ViewScoped
@Component
public class AspiranteBean implements Serializable {

    @Getter @Setter
    private Aspirante aspirante;

    @Getter @Setter
    private List<Profesion> profesiones;

    private final AspiranteServicio aspiranteServicio;

    private final ProfesionServicio profesionServicios;


    public AspiranteBean(AspiranteServicio aspiranteServicio, ProfesionServicio profesionServicios) {
        this.aspiranteServicio = aspiranteServicio;
        this.profesionServicios = profesionServicios;
    }

    @PostConstruct
    public void inicializar(){

        aspirante=new Aspirante();
        profesiones=profesionServicios.listarProfesion();
    }

    public void registrarAspirante(){

        try {
            aspiranteServicio.registrarAspirante(aspirante);
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Registro Exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {

            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void actualizarAspirante(){

        try {
            aspiranteServicio.actualizarAspirante(aspirante);
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Actualizacion Exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {

            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }


    public void eliminarAspirante(){

        try {
            aspiranteServicio.eliminarAspirante(aspirante.getId());
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Registro Exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {

            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }


    public void listarAspirante(){

      List<Aspirante>listaAspirantes=  aspiranteServicio.listarAspirantes();

        listaAspirantes.forEach(u -> System.out.println(u));

    }


}
