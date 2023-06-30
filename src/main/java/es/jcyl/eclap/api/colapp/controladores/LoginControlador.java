package es.jcyl.eclap.api.colapp.controladores;


import es.jcyl.eclap.api.colapp.ColAppDeroApiApplication;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginControlador {

    private static final Log LOGGER = LogFactory.getLog(ColAppDeroApiApplication.class);
    @Autowired
    private UsuariosRepo usuariosRepo;

    @GetMapping("/api/v1/usuarios")
    public List<Usuario> todosUsuarios() {
        LOGGER.info("Leyendo todos los usuarios");
        return usuariosRepo.findAll();
    }

    @GetMapping("/api/v1/usuarios/{id}")
    public Optional<Usuario> usuarioPorId(@PathVariable Integer id) {
        LOGGER.info("Leyendo usuario : " + id);

        return usuariosRepo.findById(id);
    }


    @PostMapping("/api/v1/login")
    public Usuario login(String usuario,String contrasena) {

        return null;
    }


}
