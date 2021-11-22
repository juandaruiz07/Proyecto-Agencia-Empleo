package co.agencia.proyecto.converter;


import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.servicios.ProfesionServicio;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@Component
public class ProfesionConverter implements Converter<Profesion>, Serializable {

    private final ProfesionServicio profesionServicio;

    public ProfesionConverter(ProfesionServicio profesionServicio) {
        this.profesionServicio = profesionServicio;
    }


    @Override
    public Profesion getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Profesion profesion=null;

        try {
            profesion=profesionServicio.obtenerProfesion(Integer.parseInt(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return profesion;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Profesion profesion) {
      if(profesion!=null){

          String id=String.valueOf(profesion.getId());

          return id ;

      }


        return " ";
    }
}
