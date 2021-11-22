package co.agencia.proyecto.servicios;

import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Oferta;

import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
public interface OfertaServicio {


    Oferta registrarOferta(Oferta o)throws Exception;

    Oferta actualizarOferta(Oferta o)throws Exception;

    void eliminarOferta(Integer id)throws Exception;

    List<Oferta> listarOfertas();

    Oferta obtenerOferta(Integer id)throws Exception;


    Oferta programarTiempoOferta(Oferta o);
}
