package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervezasRepo extends JpaRepository<Cerveza, Long> {

}
