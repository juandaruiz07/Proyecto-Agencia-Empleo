package co.agencia.proyecto.repositorios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Empleabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@Repository
public interface EmpleabilidadRepo extends JpaRepository<Empleabilidad,Integer> {


}
