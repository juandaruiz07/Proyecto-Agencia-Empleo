package co.agencia.proyecto.servicios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.repositorios.AgenciaRepo;
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
public class AgenciaServicioImpl implements AgenciaServicio{

@Autowired
private AgenciaRepo agenciaRepo;


    @Override
    public Agencia registrarAgencia(Agencia a) throws Exception {

        Optional<Agencia> agenciaBuscada=agenciaRepo.findById(a.getNit());

        if(agenciaBuscada.isPresent() ){

            throw new Exception("Ya hay una Agencia con ese nit registrada");
        }


        return agenciaRepo.save(a);
    }

    @Override
    public Agencia actualizarAgencia(Agencia a) throws Exception {

        Optional<Agencia> agenciaBuscada=agenciaRepo.findById(a.getNit());

        if(agenciaBuscada.isEmpty() ){
            throw new Exception("No existe una Agencia asociada a ese nit");
        }

        return agenciaRepo.save(a);
    }

    @Override
    public void eliminarAgencia(Integer nit) throws Exception {
        Optional<Agencia> agenciaBuscada = agenciaRepo.findById(nit);

        if (agenciaBuscada.isEmpty()) {

            throw new Exception("No existe una Agencia asociada a ese nit");
        }

        agenciaRepo.deleteById(nit);

    }

    @Override
    public List<Agencia> listarAgencias() {
        return agenciaRepo.findAll();
    }

    @Override
    public Agencia obtenerAgencia(Integer nit) throws Exception {

       Agencia agenciaEncontrada= agenciaRepo.findByNit(nit);

       if(agenciaEncontrada==null){
           throw new Exception("No existe una Agencia asociada a ese nit");
       }
        return agenciaEncontrada ;
    }
}
