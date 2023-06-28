package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepositorio extends JpaRepository<Nota, Long> {
}
