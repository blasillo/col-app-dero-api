package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;

import java.util.List;
import java.util.Optional;

public interface CervezasPersonalRepo {

    List<Cerveza> findByConsulta(String consulta);

    /*
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUserId(String userId);
     */
}
