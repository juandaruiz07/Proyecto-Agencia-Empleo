package co.agencia.proyecto.servicios;

import co.agencia.proyecto.entidades.Agencia;

import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
public interface AgenciaServicio {


    //RF1

    Agencia registrarAgencia(Agencia a)throws Exception;

    Agencia actualizarAgencia(Agencia a)throws Exception;

    void eliminarAgencia(Integer nit)throws Exception;

    List<Agencia> listarAgencias();

    Agencia obtenerAgencia(Integer nit)throws Exception;



}


