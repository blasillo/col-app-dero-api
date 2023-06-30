package es.jcyl.eclap.api.colapp.persistencia.repositorios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CervezasRepo extends JpaRepository<Cerveza, Long>, CervezasPersonalRepo {


    //@Query ("SELECT c FROM Cerveza c WHERE upper(c.nombre) LIKE CONCAT('%',upper(:consulta),'%')")
    //@Query (value="select c.* from colapp.cervezas c where upper(c.nombre) like '%' ||  upper(:consulta) ||'%'", nativeQuery = true)
    //List<Cerveza> findByConsulta(@Param("consulta")String consulta);

}
