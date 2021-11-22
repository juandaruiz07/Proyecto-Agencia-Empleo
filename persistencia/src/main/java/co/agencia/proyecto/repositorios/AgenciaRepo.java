package co.agencia.proyecto.repositorios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */

@Repository
public interface AgenciaRepo extends JpaRepository<Agencia,Integer> {

Agencia findByNit(int id);

Agencia findAllByNombre(String nombre);





}
