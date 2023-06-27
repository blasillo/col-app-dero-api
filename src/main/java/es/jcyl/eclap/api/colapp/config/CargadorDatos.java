package es.jcyl.eclap.api.colapp.config;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CargadorDatos implements ApplicationRunner {

    List<Usuario>  listaUsuarios = Arrays.asList(
              Usuario.builder()
                      .id(1)
                      .email("administrador-colapp@jcyl.es")
                      .password("supersecreto")
                      .nombre("Administrador")
                      .rol("ADMINISTRADOR")
                      .passwordHash("")
                      .build(),
            Usuario.builder()
                    .id(2)
                    .email("TorGomRo@jcyl.es")
                    .password("TorGomRo")
                    .nombre("Roberto Torres")
                    .rol("USUARIO")
                    .passwordHash("")
                    .build()
            );


    @Autowired
    private UsuariosRepo usuariosRepo;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        usuariosRepo.saveAll(listaUsuarios);

    }
}
