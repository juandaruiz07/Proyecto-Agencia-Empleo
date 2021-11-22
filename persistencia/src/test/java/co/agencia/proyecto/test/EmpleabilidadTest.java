package co.agencia.proyecto.test;


import co.agencia.proyecto.entidades.*;
import co.agencia.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmpleabilidadTest {



    @Autowired
    private AspiranteRepo aspiranteRepo;

    @Autowired
    private OfertaRepo ofertaRepo;

    @Autowired
    private EmpleabilidadRepo empleabilidadRepo;

    @Autowired
    private ProfesionRepo profesionRepo;

    @Autowired
    private AgenciaRepo agenciaRepo;




    @Test
    public void registrarTest() {


        Profesion profesion = new Profesion(1, "Abogado");
        profesionRepo.save(profesion);

        Agencia agencia = new Agencia(01, "Empleo1", "2323123", "Cra23-32-32");
        agenciaRepo.save(agencia);

        Aspirante aspirante = new Aspirante(10,"David",43,'M',profesion,null);
        aspiranteRepo.save(aspirante);

        Oferta oferta=new Oferta(22,"Interno","Empleo en planta como interno", LocalDateTime.of(2021, 12, 12, 23, 59),LocalDateTime.of(2022, 02, 12, 23, 59));
        ofertaRepo.save(oferta);

        Empleabilidad empleabilidad=new Empleabilidad(34,aspirante,oferta,LocalDateTime.of(2021, 11, 12, 23, 59));
        Empleabilidad empleabilidadGuardada=empleabilidadRepo.save(empleabilidad);

         Assertions.assertNotNull(empleabilidadGuardada);

    }


    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest() {


        Empleabilidad empleabilidad=empleabilidadRepo.findById(1).orElse(null);
        empleabilidadRepo.delete(empleabilidad);
        empleabilidad=empleabilidadRepo.findById(1).orElse(null);

        Assertions.assertNull(empleabilidad);
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest() {
        Oferta oferta=new Oferta(22,"Interno","Empleo en planta como interno", LocalDateTime.of(2021, 12, 12, 23, 59),LocalDateTime.of(2022, 02, 12, 23, 59));
        ofertaRepo.save(oferta);

        Empleabilidad empleabilidad=empleabilidadRepo.findById(1).orElse(null);
        empleabilidad.setOferta(oferta);

        Assertions.assertEquals("Interno", empleabilidad.getOferta().getNombre());
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest() {

        List<Empleabilidad> listaEmpleabilidad=empleabilidadRepo.findAll();
        listaEmpleabilidad.forEach(u -> System.out.println(u));


    }



}
