package co.agencia.proyecto.servicios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Aspirante;

import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
public interface AspiranteServicio {

     //RF2
    Aspirante registrarAspirante(Aspirante a)throws Exception;

    Aspirante actualizarAspirante(Aspirante a)throws Exception;

    void eliminarAspirante(Integer id)throws Exception;

    List<Aspirante> listarAspirantes();

    Aspirante obtenerAspirante(Integer id)throws Exception;


    //RF3
    Integer obtenerNombresAspi(char letra)throws Exception;

    //RF7
    Boolean permitirRegistroOferta(int id)throws Exception;

    //RF9
    List<Aspirante>MostrarAspirantesProfesion();



}
