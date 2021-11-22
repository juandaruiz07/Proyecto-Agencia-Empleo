package co.agencia.proyecto.repositorios;

import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Profesion;
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
public interface AspiranteRepo extends JpaRepository<Aspirante,Integer> {



    @Query("select count(a) from Aspirante a where a.nombre like concat(:letra,'%') ")
Integer buscarAspLetraInicial(char letra);


    @Query("select a from Aspirante a order by (a.edad)desc ")
    List<Aspirante> buscarAspMayor();


    @Query("select a from Aspirante a where a.profesion.nombre=:profesion")
    List<Aspirante>aspirantesPorProfesion(String profesion);


    @Query("select a from Profesion p join p.aspirantes a ")
    List<Aspirante>registrosPorProfesion();


    @Query("select a.nombre,a.genero,p.nombre from Aspirante a  join a.profesion p group by p.nombre")
    List<Object[]>aspirantesPorGeneroYProfesion();



}
