package co.agencia.proyecto.test;


import co.agencia.proyecto.entidades.Oferta;
import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.repositorios.ProfesionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfesionTest {

   @Autowired
private ProfesionRepo profesionRepo;

   @Test
   public void registrarTest(){

       Profesion profesion=new Profesion(1,"Mecanico");
       Profesion profesionGuardada=profesionRepo.save(profesion);

       Assertions.assertNotNull(profesionGuardada);
   }

    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest() {

       Profesion profesion=profesionRepo.findById(1).orElse(null);

       profesionRepo.delete(profesion);

        profesion=profesionRepo.findById(1).orElse(null);

        Assertions.assertNull(profesion);

    }

    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest() {

        Profesion profesion=profesionRepo.findById(1).orElse(null);
        profesion.setNombre("Modificado");

        Assertions.assertEquals("Modificado", profesion.getNombre());
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest() {

        List<Profesion>listaProfesiones=profesionRepo.findAll();

        listaProfesiones.forEach(u -> System.out.println(u));

    }



}
