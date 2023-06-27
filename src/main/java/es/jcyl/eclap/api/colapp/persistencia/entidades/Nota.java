package es.jcyl.eclap.api.colapp.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name="NOTAS")
public class Nota {

    @Id
    private Long id;
    private Timestamp creado;
    private String titulo;
    private String contenido;
    private Boolean notaPublica;

    //private Usuario usuario;



}
