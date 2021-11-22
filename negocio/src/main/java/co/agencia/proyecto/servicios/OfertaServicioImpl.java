package co.agencia.proyecto.servicios;


import co.agencia.proyecto.entidades.Oferta;
import co.agencia.proyecto.repositorios.OfertaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@Service
public class OfertaServicioImpl implements OfertaServicio{

    @Autowired
    private OfertaRepo ofertaRepo;


    @Override
    public Oferta registrarOferta(Oferta o) throws Exception {

        Optional<Oferta> ofertaBuscada=ofertaRepo.findById(o.getId());

        if(ofertaBuscada.isPresent()){
            throw new Exception("Ya hay una oferta registrada con ese id");
        }

        return ofertaRepo.save(o);
    }

    @Override
    public Oferta actualizarOferta(Oferta o) throws Exception {
        Optional<Oferta> ofertaBuscada=ofertaRepo.findById(o.getId());
        if(ofertaBuscada.isEmpty()){
            throw new Exception("No hay una oferta registrada con ese id");
        }
        return ofertaRepo.save(o);
    }

    @Override
    public void eliminarOferta(Integer id) throws Exception {


        Optional<Oferta> ofertaBuscada=ofertaRepo.findById(id);
        if(ofertaBuscada.isEmpty()){
            throw new Exception("No hay una oferta registrada con ese id");
        }

        ofertaRepo.deleteById(id);

    }

    @Override
    public List<Oferta> listarOfertas() {


        return ofertaRepo.findAll();
    }

    @Override
    public Oferta obtenerOferta(Integer id) throws Exception {

        return ofertaRepo.findById(id).orElseThrow(()-> new Exception ("El id no corresponde a ninguna oferta"));
    }

    @Override
    public Oferta programarTiempoOferta(Oferta o) {


        LocalDateTime fechaFin=o.getFechaInicio().plusDays(5);
        o.setFechaFin(fechaFin);
        return o;
    }
}
