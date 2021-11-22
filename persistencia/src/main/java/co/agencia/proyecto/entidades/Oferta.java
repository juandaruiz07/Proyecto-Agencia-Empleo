package co.agencia.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Oferta {


    @Id
    @Positive
    @Size(max = 11)
    @EqualsAndHashCode.Include
    private int id;

    @Length(max = 50)
    private String nombre;

    @Length(max = 255)
    private String descripcion;

    @Length(max = 20)
    private LocalDateTime fechaInicio;

    @Length(max = 20)
    private LocalDateTime fechaFin;

    @ToString.Exclude
    @OneToMany(mappedBy = "oferta")
    private List<Empleabilidad> empleabilidades;

    public Oferta(int id, String nombre, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
