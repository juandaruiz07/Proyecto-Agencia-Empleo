package co.agencia.proyecto.test;

import co.agencia.proyecto.entidades.Empleabilidad;
import co.agencia.proyecto.entidades.Oferta;
import co.agencia.proyecto.repositorios.OfertaRepo;
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
public class OfertaTest {


    @Autowired
    private OfertaRepo ofertaRepo;

    @Test
    public void registrarTest(){

        Oferta oferta=new Oferta(10,"Vacante Solicitado","Se requiere vacante con PHD", LocalDateTime.of(2021, 12, 12, 23, 59),LocalDateTime.of(2022, 01, 12, 23, 59));

        Oferta ofertaGuardada=ofertaRepo.save(oferta);

        Assertions.assertNotNull(ofertaGuardada);

    }

    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest() {

      Oferta oferta=ofertaRepo.findById(10).orElse(null);
      ofertaRepo.delete(oferta);
      oferta=ofertaRepo.findById(10).orElse(null);

        Assertions.assertNull(oferta);
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest() {

        Oferta oferta=ofertaRepo.findById(10).orElse(null);
        oferta.setNombre("Modificado");

Oferta ofertaActualizada=ofertaRepo.save(oferta);
        Assertions.assertEquals("Modificado", ofertaActualizada.getNombre());

    }


    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest() {

        List<Oferta> listaOfertas=ofertaRepo.findAll();
        listaOfertas.forEach(u -> System.out.println(u));

    }



    @Test
    @Sql("classpath:Datos.sql")
    public void programarTiempoOferta() {

        Oferta oferta=new Oferta(12,"Vacante","Se necesita persona urgente",LocalDateTime.now(),LocalDateTime.now());

        LocalDateTime fechaFin=oferta.getFechaFin().plusDays(5);
        oferta.setFechaFin(fechaFin);

        Assertions.assertEquals(fechaFin, oferta.getFechaFin());

    }



}
