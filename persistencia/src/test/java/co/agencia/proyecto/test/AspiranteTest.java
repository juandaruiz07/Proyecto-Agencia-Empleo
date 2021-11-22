package co.agencia.proyecto.test;


import co.agencia.proyecto.entidades.Agencia;
import co.agencia.proyecto.entidades.Aspirante;
import co.agencia.proyecto.entidades.Empleabilidad;
import co.agencia.proyecto.entidades.Profesion;
import co.agencia.proyecto.repositorios.AgenciaRepo;
import co.agencia.proyecto.repositorios.AspiranteRepo;
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
public class AspiranteTest {


    @Autowired
    private AspiranteRepo aspiranteRepo;
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

        Aspirante aspirante = new Aspirante(10,"juan",32,'M',profesion,agencia);

        Aspirante aspiranteGuardado = aspiranteRepo.save(aspirante);

        Assertions.assertNotNull(aspiranteGuardado);

    }

    @Test
    @Sql("classpath:Datos.sql")
    public void eliminarTest() {

       Aspirante aspirante=aspiranteRepo.findById(22).orElse(null);
       aspiranteRepo.delete(aspirante);
        aspirante=aspiranteRepo.findById(22).orElse(null);

           Assertions.assertNull(aspirante);
    }

    @Test
    @Sql("classpath:Datos.sql")
    public void actualizarTest() {

        Aspirante aspirante=aspiranteRepo.findById(22).orElse(null);
       aspirante.setNombre("Modificado");


        Assertions.assertEquals("Modificado", aspirante.getNombre());
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void listarTest(){

        List<Aspirante> listaAspirantes=aspiranteRepo.findAll();

        listaAspirantes.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:Datos.sql")
    public void buscarPorLetraInicialTest(){

char letra='j';
        int cantidadUsuarios=aspiranteRepo.buscarAspLetraInicial('j');

        System.out.println("Aspirantes con la letra "+letra+ " son: " + cantidadUsuarios);
    }


    @Test
    @Sql("classpath:Datos.sql")
    public void buscarAspMayor(){

  List<Aspirante> aspiranteMayor=aspiranteRepo.buscarAspMayor();


        System.out.println("El aspirante con mayor edad es: "+aspiranteMayor.get(0).getNombre()+
                " con "+aspiranteMayor.get(0).getEdad()+" años");

    }

    @Test
    @Sql("classpath:Datos.sql")
    public void buscarPorProfesion(){
        List<Aspirante> aspirantes=aspiranteRepo.aspirantesPorProfesion("Abogado");

           aspirantes.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Datos.sql")
    public void aspirantesPorProfesion(){

        List<Aspirante>aspirantes=aspiranteRepo.registrosPorProfesion();


        aspirantes.forEach(System.out::println);
    }



    @Test
    @Sql("classpath:Datos.sql")
    public void controlarRegistroOferta(){
       Aspirante aspiranteBuscado=aspiranteRepo.findById(22).orElse(null);

       if(aspiranteBuscado !=null){

           int numEmpleabilidades=aspiranteBuscado.getEmpleabilidades().size();

           if(numEmpleabilidades!=0){

               System.out.println("El aspirante ya se encuentra postulado en otra oferta");
           }else{

               System.out.println(" Se aplico a esta oferta");
           }
Assertions.assertEquals(0, numEmpleabilidades);

       }



    }



}
