package es.jcyl.eclap.api.colapp.config;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Cerveza;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Imagen;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Nota;
import es.jcyl.eclap.api.colapp.persistencia.entidades.Usuario;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.CervezasRepo;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.ImagenesRepo;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.NotasRepositorio;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.UsuariosRepo;
import es.jcyl.eclap.api.colapp.utiles.ImagenUtiles;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOError;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Component
public class CargadorDatos implements ApplicationRunner {

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private CervezasRepo cerevezasRepo;

    @Autowired
    private ImagenesRepo imagenesRepo;

    @Autowired
    private NotasRepositorio notasRepo;

    @Autowired
    private ResourcePatternResolver resolver;

    List<Usuario>  listaUsuarios = Arrays.asList(
              Usuario.builder()
                      .id(1)
                      .email("administrador-colapp@jcyl.es")
                      .password("supersecreto")
                      .nombre("Administrador")
                      .rol("ADMINISTRADOR")
                      .passwordHash("")
                      .build(),
            Usuario.builder()
                    .id(2)
                    .email("TorGomRo@jcyl.es")
                    .password("TorGomRo")
                    .nombre("Roberto Torres")
                    .rol("USUARIO")
                    .passwordHash("")
                    .build()
            );

    List<Cerveza>  listaCervezas = Arrays.asList(
            Cerveza.builder()
                    .id(1L).nombre("Duvel").imagen("duvel.png")
                    .alcohol(8.5)
                    .color("Rubia")
                    .categoria("Strong Blond")
                    .descripcion("Cerveza especial belga de alta fermentación, con segunda fermentación en botella. Aromas afrutados, evocando el olor a pera y manzana.")
                    .build(),
            Cerveza.builder()
                    .id(2L)
                    .nombre("Chimay Triple")
                    .imagen("chimay_triple.png")
                    .alcohol( 8.0)
                    .color ("Rubia")
                    .categoria("Triple Trappist")
                    .descripcion("La cerveza de Triple de Chimay es la más reciente de la abadía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco común.")
                    .build()
    );

    List<Nota> notas = Arrays.asList(
            Nota.builder()
                .id(1L)
                .usuario( listaUsuarios.get(0))
                .titulo("Sobrevalorada cerveza")
                .contenido("La cerveza en sí no está mal, pero demasiada fama para lo que es")
                .notaPublica(Boolean.TRUE)
                .cerveza( listaCervezas.get(1))
                .build()
    );



    private void cargadorImagenes () throws IOException{
        final String root = resolver.getResource("classpath:/static/imagenes").getURI().toString();
        Resource[] resources = resolver.getResources("classpath:/static/imagenes/*.png");
        cargadorRecursos( resources, "image/png");
        resources = resolver.getResources("classpath:/static/imagenes/*.jpg");
        cargadorRecursos( resources, "image/jpeg");
    }

    private void cargadorRecursos (Resource[] resources, String tipo) throws IOException {
        final List<String> fileNames = Stream.of(resources)
                .filter(Resource::isFile)
                .map(r -> {
                    try {
                        Imagen imagen = Imagen.builder()
                                .nombre(r.getFile().getName())
                                .tipo( tipo )
                                .datos(ImagenUtiles.comprimirImagen(  FileUtils.readFileToByteArray(r.getFile()) ))
                                .build();

                        imagenesRepo.save( imagen );

                        return r.getURI().toString();
                    } catch (final IOException e) {
                        throw new IOError(e);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        usuariosRepo.saveAll(listaUsuarios);
        cerevezasRepo.saveAll( listaCervezas);
        notasRepo.saveAll( notas );

        cargadorImagenes();

    }
}
