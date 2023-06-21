package es.jcyl.eclap.api.colapp.controladores;


import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalControlador {

    @GetMapping("/hola")
    String hola() {
        return "{\"mensaje\": \"Hola\"}";
    }



}
