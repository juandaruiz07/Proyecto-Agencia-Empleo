package co.agencia.proyecto.repositorios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@Repository
public interface OfertaRepo extends JpaRepository<Oferta,Integer> {






}
