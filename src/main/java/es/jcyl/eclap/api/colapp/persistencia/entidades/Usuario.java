package es.jcyl.eclap.api.colapp.persistencia.entidades;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    //@GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String email;
    private String password;
    private String passwordHash;
    private String nombre;
    private String rol;
}
