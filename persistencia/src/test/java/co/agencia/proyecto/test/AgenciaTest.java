package co.agencia.proyecto.test;


import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Oferta;
import co.agencia.proyecto.repositorios.AgenciaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AgenciaTest {


    @Autowired
    private AgenciaRepo agenciaRepo;


    @Test
    public void registrarTest() {

        Agencia agencia = new Agencia(01, "Empleo1", "2323123", "Cra23-32-32");

        Agencia agenciaGuardada = agenciaRepo.save(agencia);

        Assertions.assertNotNull(agenciaGuardada);

    }


    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest() {

        Optional<Agencia> agenciaConsultada = agenciaRepo.findById(01);

        if (agenciaConsultada.isEmpty()) {

            System.out.println("La agencia no existe");

        } else{

            agenciaRepo.deleteById(01);

            agenciaConsultada = agenciaRepo.findById(01);

            Assertions.assertNull(agenciaConsultada);


        }

    }


    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest() {

        Agencia agenciaConsultada = agenciaRepo.findByNit(01);

        if (agenciaConsultada != null) {

            agenciaConsultada.setNombre("Modificado");

            Agencia agenciaActualizada=agenciaRepo.save(agenciaConsultada);

            Assertions.assertEquals("Modificado", agenciaActualizada.getNombre());

        } else {

            System.out.println("La agencia no existe");
        }
    }

    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest() {

        List<Agencia> listaAgencias = agenciaRepo.findAll();

            listaAgencias.forEach(u -> System.out.println(u));
    }







}
