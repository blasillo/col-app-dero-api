package es.jcyl.eclap.api.colapp.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="NOTAS", schema = "COLAPP")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="NOTA_ID")
    private Long id;
    @Column(name="F_CREACION")
    @CreationTimestamp
    private Timestamp creado;

    @Column(name="TITULO", length=120)
    private String titulo;

    @Column(name="CONTENIDO", length=1024)
    private String contenido;
    @Column(name="B_NOTA_PUBLICA")
    private Boolean notaPublica;

    @OneToOne
    @JoinColumn (name = "USUARIO_ID", nullable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "CERVEZA_ID", nullable = false, updatable = false)
    private Cerveza cerveza;

}
