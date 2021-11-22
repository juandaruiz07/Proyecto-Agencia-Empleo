package co.agencia.proyecto.test;


import co.agencia.proyecto.NegocioApplication;
import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.servicios.AgenciaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class AgenciaServicioTest {


    @Autowired
    private AgenciaServicio agenciaServicio;


@Test
    public void registrarTest(){
        Agencia agencia = new Agencia(23, "Empleo1", "2323123", "Cra23-32-32");
        try {
            Agencia agenciaGuardada=agenciaServicio.registrarAgencia(agencia);
            Assertions.assertNotNull(agenciaGuardada);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest(){
        try {
            Agencia agencia = agenciaServicio.obtenerAgencia(01);
            agencia.setNombre("Modificado");
            Agencia agenciaActualizada=agenciaServicio.actualizarAgencia(agencia);
            Assertions.assertNotNull(agenciaActualizada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest(){

        List<Agencia>listaAgencias=agenciaServicio.listarAgencias();

        listaAgencias.forEach(u -> System.out.println(u));

    }



}
