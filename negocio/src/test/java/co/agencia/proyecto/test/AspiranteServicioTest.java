package co.agencia.proyecto.test;


import co.agencia.proyecto.NegocioApplication;
import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.servicios.AgenciaServicio;
import co.agencia.proyecto.servicios.AspiranteServicio;
import co.agencia.proyecto.servicios.ProfesionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class AspiranteServicioTest {

    @Autowired
    private AspiranteServicio aspiranteServicio;

    @Autowired
    private ProfesionServicio profesionServicios;

    @Autowired
    private AgenciaServicio agenciaServicio;

@Test
public void registrarTest() {
    Agencia agencia = new Agencia(23, "Empleo1", "2323123", "Cra23-32-32");


    Profesion profesion = new Profesion(1, "Mecanico");


    Aspirante aspirante = new Aspirante(10, "juan", 32, 'M', profesion, agencia);
    try {
        agenciaServicio.registrarAgencia(agencia);
        profesionServicios.registrarProfesion(profesion);
        Aspirante aspiranteGuardado = aspiranteServicio.registrarAspirante(aspirante);

        Assertions.assertNotNull(aspiranteGuardado);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest(){

        try {
            aspiranteServicio.eliminarAspirante(22);
            Aspirante aspiranteBuscado=aspiranteServicio.obtenerAspirante(22);
            Assertions.assertNull(aspiranteBuscado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void modificarTest(){

        try {
            Aspirante aspiranteBuscado=aspiranteServicio.obtenerAspirante(22);
            aspiranteBuscado.setNombre("Modificado");
            Aspirante aspiranteActualizado=aspiranteServicio.actualizarAspirante(aspiranteBuscado);
            Assertions.assertEquals("Modificado", aspiranteActualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest(){

        List<Aspirante>listaAspirantes=aspiranteServicio.listarAspirantes();

        listaAspirantes.forEach(u -> System.out.println(u));

    }


}




