package co.agencia.proyecto.bean;


import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.servicios.AgenciaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */

@ViewScoped
@Component
public class AgenciaBean {

    @Getter @Setter
    private Agencia agencia;



    private final AgenciaServicio agenciaServicio;

    public AgenciaBean(AgenciaServicio agenciaServicio) {
        this.agenciaServicio = agenciaServicio;
    }


    @PostConstruct
    public void inicializar(){
    agencia=new Agencia();
    }


    public void registrarAgencia(){

        try {
            agenciaServicio.registrarAgencia(agencia);
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Registro Exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }



    public void actaulizarAgencia(){
        try {
            agenciaServicio.actualizarAgencia(agencia);
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Actualizacion Exitosa");
            FacesContext.getCurrentInstance().addMessage(null, msg);


        } catch (Exception e) {
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


    }

    public void eliminarAgencia(){
        try {
            agenciaServicio.eliminarAgencia(agencia.getNit());
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Eliminacion Exitosa");
            FacesContext.getCurrentInstance().addMessage(null, msg);


        } catch (Exception e) {
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }


    public void listarAgencias(){


       List<Agencia> agencias= agenciaServicio.listarAgencias();

        agencias.forEach(u -> System.out.println(u));

    }
}
