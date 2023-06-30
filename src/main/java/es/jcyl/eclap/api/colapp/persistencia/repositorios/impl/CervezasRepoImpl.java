package es.jcyl.eclap.api.colapp.persistencia.repositorios.impl;


import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.CervezasPersonalRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CervezasRepoImpl implements CervezasPersonalRepo {

    private static final Logger LOG = LoggerFactory.getLogger(CervezasRepoImpl.class);


    private static final String SQL_BUSQUEDA =
            "select c.* " +
            "from colapp.cervezas c " +
            "where upper(c.nombre) like '%%' || upper('%s') || '%%'";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cerveza> findByConsulta(String consulta) {
        List<Cerveza> cervezas = consultaBaseDeDatos(SQL_BUSQUEDA, consulta);

        return cervezas;
    }


    private List<Cerveza> consultaBaseDeDatos (String query, Object... params) {
        String formattedQuery = String.format(query, params);
        Query nativeQuery = this.em.createNativeQuery(formattedQuery);
        LOG.debug("Consultando cervezas con {}", formattedQuery);
        List<Object[]> result = nativeQuery.getResultList();
        if (result == null || result.size() == 0) {
            return Arrays.asList();
        }

        return result.stream().map( r -> mapeoResultadosEntidad(r)).collect(Collectors.toList());
    }


    private Cerveza mapeoResultadosEntidad (Object[] result) {
        Cerveza cerveza = new Cerveza();

        cerveza.setId( new Long( result[0].toString() ) );
        cerveza.setAlcohol(new Double(result[1].toString()));
        cerveza.setCategoria(result[2].toString());
        cerveza.setColor(result[3].toString());
        cerveza.setDescripcion(result[4].toString());
        cerveza.setImagen(result[5].toString());
        cerveza.setNombre(result[6].toString());

        return cerveza;
    }
}
