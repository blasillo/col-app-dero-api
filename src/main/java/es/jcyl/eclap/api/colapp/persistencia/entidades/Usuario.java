package es.jcyl.eclap.api.colapp.persistencia.entidades;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.security.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="USUARIO_ID")
    private Integer id;
    @Column(name="EMAIL",unique = true,nullable = false,length = 200)
    private String email;
    @Column(name="CONTRASENA", nullable = false,length = 32)
    private String password;

    @Column (name="CONTRASENA_HASH", length=256)
    private String passwordHash;
    @Column (name="NOMBRE_USUARIO", nullable = false, length = 64)
    private String nombre;

    @Column (name="ROL_USUARIO", length = 32)
    private String rol;

}
