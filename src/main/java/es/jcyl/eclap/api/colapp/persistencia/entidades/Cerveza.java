package es.jcyl.eclap.api.colapp.persistencia.entidades;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CERVEZAS",schema = "COLAPP")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cerveza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "CERVEZA_ID")
    private Long id;
    @Column (name="NOMBRE", length = 120, nullable = false)
    private String nombre;
    @Column (name="IMAGEN", length = 256)
    private String imagen;
    @Column (name="ALCOHOL")
    private Double alcohol;
    @Column (name="COLOR", length= 64)
    private String color;
    @Column (name="CATEGORIA", length=120)
    private String categoria;
    @Column(name="DESCRIPCION", length=1024)
    private String descripcion;

    @JsonManagedReference
    @OneToMany (fetch=FetchType.LAZY,  mappedBy = "cerveza")
    private List<Nota> notas;

}
