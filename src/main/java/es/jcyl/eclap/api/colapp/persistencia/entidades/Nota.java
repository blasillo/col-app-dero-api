package es.jcyl.eclap.api.colapp.persistencia.entidades;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="NOTAS", schema = "COLAPP")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="NOTA_ID")
    private Long id;
    private Timestamp creado;
    private String titulo;
    private String contenido;
    private Boolean notaPublica;

    @OneToOne
    @JoinColumn (name = "USUARIO_ID", nullable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "CERVEZA_ID", nullable = false, updatable = false)
    private Cerveza cerveza;




}
