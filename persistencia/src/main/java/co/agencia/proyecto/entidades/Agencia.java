package co.agencia.proyecto.entidades;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Agencia {


    @Id
    @Positive
    @Size(max = 11)
    @EqualsAndHashCode.Include
    private int nit;

    @Length(max = 50)
    @Column(nullable = false)
    private String nombre;

    @Length(max = 16)
    @Column(nullable = false)

    private String telefono;

    @Length(max = 50)
    private String direccion;

    @ToString.Exclude
    @OneToMany(mappedBy = "agencia")
    private List<Aspirante> aspirantes;

    @ToString.Exclude
    @OneToMany(mappedBy = "agencia")
    private List<Profesion>profesiones;



    public Agencia(int nit, String nombre, String telefono, String direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
