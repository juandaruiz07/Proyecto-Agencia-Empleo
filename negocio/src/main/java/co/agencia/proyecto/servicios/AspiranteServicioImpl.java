package co.agencia.proyecto.servicios;


import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.repositorios.AspiranteRepo;
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
public class AspiranteServicioImpl implements AspiranteServicio {


    private final AspiranteRepo aspiranteRepo;

    public AspiranteServicioImpl(AspiranteRepo aspiranteRepo) {
        this.aspiranteRepo = aspiranteRepo;
    }


    @Override
    public Aspirante registrarAspirante(Aspirante a) throws Exception {

        Optional<Aspirante> aspiranteBuscado = aspiranteRepo.findById(a.getId());


        if (aspiranteBuscado.isPresent()) {

            throw new Exception("Ya hay un Aspirante con esa cedula registrado");
        }

        return aspiranteRepo.save(a);
    }

    @Override
    public Aspirante actualizarAspirante(Aspirante a) throws Exception {

        Optional<Aspirante> aspiranteBuscado = aspiranteRepo.findById(a.getId());

        if (aspiranteBuscado.isEmpty()) {

            throw new Exception("No hay un Aspirante con esa cedula registrado");
        }

        return aspiranteRepo.save(a);
    }

    @Override
    public void eliminarAspirante(Integer id) throws Exception {

        Optional<Aspirante> aspiranteBuscado = aspiranteRepo.findById(id);

        if (aspiranteBuscado.isEmpty()) {

            throw new Exception("No hay un Aspirante con esa cedula registrado");
        }

        aspiranteRepo.deleteById(id);


    }

    @Override
    public List<Aspirante> listarAspirantes() {
        return aspiranteRepo.findAll();
    }

    @Override
    public Aspirante obtenerAspirante(Integer id) throws Exception {


        Optional<Aspirante> aspiranteEncontrado = aspiranteRepo.findById(id);


        if (aspiranteEncontrado.isEmpty()) {

            throw new Exception("No hay un Aspirante con esa cedula registrado");
        }
        return aspiranteEncontrado.orElseThrow(() -> new Exception("El id no corresponde a ninguna ciudad"));
    }

    @Override
    public Integer obtenerNombresAspi(char letra) throws Exception {

        int cantNombresLetraI = aspiranteRepo.buscarAspLetraInicial(letra);

        if (cantNombresLetraI == 0) {
            throw new Exception("No hay Aspirantes con nombres que inicien con esa letra");

        }
        return cantNombresLetraI;
    }

    @Override
    public Boolean permitirRegistroOferta(int id) throws Exception {
        Aspirante aspiranteBuscado = aspiranteRepo.findById(id).orElse(null);

        if (aspiranteBuscado != null) {


            int numEmpleabilidades = aspiranteBuscado.getEmpleabilidades().size();

            if (numEmpleabilidades == 0) {

                return true;
            } else {
                throw new Exception("El aspirante con ese numero de cedula ya esta inscrito a otra oferta");

            }
        }

        throw new Exception("No existe un aspirante asociado a esa cedula");
    }

    @Override
    public List<Aspirante> MostrarAspirantesProfesion() {
        List<Aspirante>listaPorProfesion=aspiranteRepo.registrosPorProfesion();


        return listaPorProfesion;
    }


}
