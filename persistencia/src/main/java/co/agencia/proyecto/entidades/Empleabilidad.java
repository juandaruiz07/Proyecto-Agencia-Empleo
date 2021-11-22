package co.agencia.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;




@ToString
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Empleabilidad {


    /**
     *
     *@project Proyecto AgenciaEmpleo
     *@author  Juan David Ruiz Garcia
     *
     */

    @Id
    @Positive
    @Size(max = 11)
    @EqualsAndHashCode.Include
    private int id;


    @ManyToOne
    private Aspirante aspirante;


    private LocalDateTime fecha;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Oferta oferta;


    public Empleabilidad(int id, Aspirante aspirante, Oferta oferta, LocalDateTime fecha) {
        this.id = id;
        this.aspirante = aspirante;
        this.oferta = oferta;
        this.fecha = fecha;
    }
}
