package co.agencia.proyecto.entidades;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;
/**
 *
 *@project Proyecto AgenciaEmpleo
 *@author  Juan David Ruiz Garcia
 *
 */

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Profesion {

@Id
@Positive
@Size(max = 11)
@ToString.Include
@EqualsAndHashCode.Include
private int id;

@Length(max = 50)
private String nombre;

@ManyToOne
@OnDelete(action = OnDeleteAction.CASCADE)
private Agencia agencia;

@ToString.Exclude
@OneToMany(mappedBy = "profesion")
private List<Aspirante> aspirantes;

    public Profesion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
