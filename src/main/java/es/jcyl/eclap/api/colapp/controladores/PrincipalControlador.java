package es.jcyl.eclap.api.colapp.controladores;


import es.jcyl.eclap.api.colapp.ColAppDeroApiApplication;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.CervezasRepo;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PrincipalControlador {

    private static final Log LOGGER = LogFactory.getLog(ColAppDeroApiApplication.class);

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private CervezasRepo cervezasRepo;


    @GetMapping("/hola")
    String hola() {
        return "{\"mensaje\": \"Hola\"}";
    }

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


    @GetMapping("/api/v1/cervezas")
    public List<Cerveza> todasCervezas() {
        LOGGER.info("Leyendo todas las cervezas");

        return cervezasRepo.findAll();
    }

    @GetMapping("/api/v1/cervezas/{id}")
    public Cerveza cervezaPorId(@PathVariable Long id) {
        LOGGER.info("Leyendo cerveza : " + id);

        return cervezasRepo.findById(id).get();
    }


    @GetMapping("/api/v1/cervezas/consulta")
    @ResponseBody
    public List<Cerveza> busquedaCervezas (@RequestParam(name = "q", required = true) String consulta){
        LOGGER.info("Consulta cervezas : " + consulta );

        return cervezasRepo.findByConsulta(consulta);
    }


}
