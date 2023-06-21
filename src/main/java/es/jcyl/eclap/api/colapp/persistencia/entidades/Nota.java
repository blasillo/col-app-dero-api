package es.jcyl.eclap.api.colapp.persistencia.entidades;

import java.sql.Timestamp;

public class Nota {

    private Long id;
    private Timestamp creado;
    private String titulo;
    private String contenido;
    private Boolean notaPublica;

    private Usuario usuario;

    private Cerveza cerveza;

}
