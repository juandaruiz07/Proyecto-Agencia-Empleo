package co.agencia.proyecto.servicios;


import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.repositorios.ProfesionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@Service
public class ProfesionServiciosImpl implements ProfesionServicio {

    @Autowired
    private ProfesionRepo profesionRepo;



    @Override
    public Profesion registrarProfesion(Profesion p) throws Exception {

        Optional<Profesion>profesionBuscada=profesionRepo.findById(p.getId());
        if(profesionBuscada.isPresent()){
            throw new Exception("Ya hay una profesion registrada con ese id");
        }
        return profesionRepo.save(p);
    }

    @Override
    public Profesion actualizarProfesion(Profesion p) throws Exception {
        Optional<Profesion>profesionBuscada=profesionRepo.findById(p.getId());
       if(profesionBuscada.isEmpty()){
           throw new Exception("No hay una profesion registrada con ese id");

       }
        return profesionRepo.save(p);
    }

    @Override
    public void eliminarProfesion(Integer id) throws Exception {
        Optional<Profesion>profesionBuscada=profesionRepo.findById(id);

        if(profesionBuscada.isEmpty()){
            throw new Exception("No hay una profesion registrada con ese id");

        }

        profesionRepo.deleteById(id);


    }

    @Override
    public List<Profesion> listarProfesion() {
        return profesionRepo.findAll();
    }

    @Override
    public Profesion obtenerProfesion(Integer id) throws Exception {

        Optional<Profesion>profesionBuscada=profesionRepo.findById(id);

        if(profesionBuscada.isEmpty()){
            throw new Exception("No hay una profesion registrada con ese id");

        }
        return profesionBuscada.orElseThrow(()-> new Exception ("El id no corresponde a ninguna ciudad"));
    }
}

