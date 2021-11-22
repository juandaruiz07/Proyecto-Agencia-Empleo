package co.agencia.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Aspirante {


    @Id
    @Positive
    @Size(max = 11)
    @EqualsAndHashCode.Include
    private int id;

    @Length(max = 50)
    @Column(nullable = false)
    private String nombre;

    @Length(max = 99, min = 18)
    @Column(nullable = false)

    private int edad;

    @Length(max = 1)
    @Column(nullable = false)

    private Character genero;

    @ManyToOne

    private Profesion profesion;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agencia agencia;

    @ToString.Exclude
    @OneToMany(mappedBy = "aspirante")
    private List<Empleabilidad> empleabilidades;

    public Aspirante(int id, String nombre, int edad, Character genero, Profesion profesion, Agencia agencia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.profesion = profesion;
        this.agencia = agencia;

    }
}
