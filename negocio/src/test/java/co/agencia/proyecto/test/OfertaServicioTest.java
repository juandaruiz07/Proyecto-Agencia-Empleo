package co.agencia.proyecto.test;


import co.agencia.proyecto.NegocioApplication;
import co.agencia.proyecto.entidades.Oferta;
import co.agencia.proyecto.servicios.OfertaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class OfertaServicioTest {



@Autowired
 private OfertaServicio ofertaServicio;


@Test
public void registrarTest(){

 Oferta oferta=new Oferta(10,"Vacante Solicitado","Se requiere vacante con PHD", LocalDateTime.of(2021, 12, 12, 23, 59),LocalDateTime.of(2022, 01, 12, 23, 59));

 try {
  Oferta ofertaGuardada= ofertaServicio.registrarOferta(oferta);
  Assertions.assertNotNull(ofertaGuardada);

 } catch (Exception e) {
  e.printStackTrace();
 }
}

@Test
@Sql("classpath:Datos.sql")
public void eliminarTest(){


 try {
  ofertaServicio.eliminarOferta(60);

  Oferta ofertaBuscada=ofertaServicio.obtenerOferta(60);

  Assertions.assertNull(ofertaBuscada);

 } catch (Exception e) {
  e.printStackTrace();
 }
}


 @Test
 @Sql("classpath:Datos.sql")
 public void actualizarTest(){


  try {

   Oferta ofertaBuscada=ofertaServicio.obtenerOferta(10);

   ofertaBuscada.setNombre("Modificado");
   Oferta ofertaActualizada=ofertaServicio.actualizarOferta(ofertaBuscada);
   Assertions.assertEquals("Modificado",ofertaActualizada.getNombre());

  } catch (Exception e) {
   e.printStackTrace();
  }
 }


 @Test
 @Sql("classpath:Datos.sql")
 public void listarTest(){

List<Oferta> listaOfertas=ofertaServicio.listarOfertas();
listaOfertas.forEach(u -> System.out.println(u));

 }




}


