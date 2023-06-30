package es.jcyl.eclap.api.colapp.servicios;

import es.jcyl.eclap.api.colapp.config.JwtTokenProveedor;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private JwtTokenProveedor jwtTokenProvider;

    //@Autowired
            //private AuthenticationManager authenticationManager;


}
