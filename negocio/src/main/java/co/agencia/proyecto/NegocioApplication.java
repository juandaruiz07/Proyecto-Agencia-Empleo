package co.agencia.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




    @SpringBootApplication
    public class NegocioApplication {
        public static void main(String[] args) {
            SpringApplication.run(co.agencia.proyecto.PersistenciaApplication.class, args);
        }
    }