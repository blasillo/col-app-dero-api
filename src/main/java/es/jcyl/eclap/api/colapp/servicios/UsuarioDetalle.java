package es.jcyl.eclap.api.colapp.servicios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UsuarioDetalle implements UserDetailsService {

    @Autowired
    private UsuariosRepo usuariosRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuariosRepo.findByEmail(username);

        if (!usuario.isPresent()) {}

        Usuario usu = usuario.get();

        return User.builder()
                .username(usu.getEmail())
                .password(usu.getPassword())
                .authorities( usu.getRol() ) // concatenar
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();

    }
}
