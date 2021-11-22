package co.agencia.proyecto.repositorios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Profesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesionRepo extends JpaRepository<Profesion,Integer> {
}
