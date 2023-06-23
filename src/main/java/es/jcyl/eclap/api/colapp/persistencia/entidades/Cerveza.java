package es.jcyl.eclap.api.colapp.persistencia.entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CERVEZAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cerveza {

    @Id
    private Long id;
    private String nombre;
    private String imagen;
    private Double alcohol;
    private String color;
    private String categoria;
    private String descripcion;

}
