package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepo extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByEmail (String email);
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmailAndPassword(String email, String pass);

}
