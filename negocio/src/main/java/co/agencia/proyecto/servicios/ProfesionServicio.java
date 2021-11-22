package co.agencia.proyecto.servicios;


import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Profesion;

import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
public interface ProfesionServicio {


    Profesion registrarProfesion(Profesion p)throws Exception;

    Profesion actualizarProfesion(Profesion p)throws Exception;

    void eliminarProfesion(Integer id)throws Exception;

    List<Profesion> listarProfesion();

    Profesion obtenerProfesion(Integer id)throws Exception;

}
