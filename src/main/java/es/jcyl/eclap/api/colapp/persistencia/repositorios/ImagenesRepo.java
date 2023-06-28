package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagenesRepo extends JpaRepository<Imagen,Long> {

    Optional<Imagen> findByNombre (String nombre);
}
