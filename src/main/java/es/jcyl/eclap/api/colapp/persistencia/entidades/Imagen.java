package es.jcyl.eclap.api.colapp.persistencia.entidades;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IMAGENES",schema = "COLAPP")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String tipo;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] datos;
}
