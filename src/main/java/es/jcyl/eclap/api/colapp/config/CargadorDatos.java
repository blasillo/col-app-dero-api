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
                    .build(),
            Usuario.builder()
                    .id(2)
                    .email("invitado@jcyl.es")
                    .password("cambialaclave")
                    .nombre("Invitado")
                    .rol("USUARIO")
                    .passwordHash("")
                    .build()
            );



    List<Cerveza>  listaCervezas = Arrays.asList(
            Cerveza.builder()
                    //.id(1L)
                    .nombre("Duvel").imagen("duvel.png")
                    .alcohol(8.5)
                    .color("Rubia")
                    .categoria("Strong Blond")
                    .descripcion("Cerveza especial belga de alta fermentación, con segunda fermentación en botella. Aromas afrutados, evocando el olor a pera y manzana.")
                    //.notas( notas )
                    .build(),
            Cerveza.builder()
                  //  .id(2L)
                    .nombre("Chimay Triple")
                    .imagen("chimay_triple.png")
                    .alcohol( 8.0)
                    .color ("Rubia")
                    .categoria("Triple Trappist")
                    .descripcion("La cerveza de Triple de Chimay es la más reciente de la abadía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco común.")
                    .build(),
            Cerveza.builder()
                    .nombre("Cornet")
                    .imagen("cornet.png")
                    .alcohol(8.5)
                    .color("Rubia")
                    .categoria("Strong Blond")
                    .descripcion("De color dorado y sutil sabor a madera, refinado y peculiar. Sensación en boca como un vino de crianza roble. Con cuerpo, toque a roble, equilibrio entre la frutosidad de la levadura y la dulzura de la vainilla.")
                    .build(),
            Cerveza.builder()
                    .nombre("Montaraz")
                    .imagen("montaraz.png")
                    .alcohol(5.3)
                    .color("Rubia")
                    .categoria("Weizen-Weissbier")
                    .descripcion("La primera creación de cervezas Montaraz, una cerveza rubia de trigo, suave, refrescante y con ligero aroma a plátano. Una cerveza artesana, elaborada en el Bierzo.")
                    .build(),
            Cerveza.builder()
                    .nombre("Ruda")
                    .imagen("ruda.jpg")
                    .alcohol(5.0)
                    .color("Tostada")
                    .categoria("Pale Ale")
                    .descripcion("Color ámbar y densa espuma, ligeramente amarga y notas dulces maltosas.")
                    .build(),
            Cerveza.builder()
                    .nombre("3 Cumbres")
                    .imagen("3cumbres.png")
                    .alcohol(4.5)
                    .color("Rubia")
                    .categoria("Lager")
                    .descripcion("De color claro, es ligera, suave y muy refrescante que está elaborada siguiendo la Ley de la Pureza Alemana. Una cerveza ideal para cualquier momento y ocasión.")
                    .build(),
            Cerveza.builder()
                    .nombre("Berzaga")
                    .imagen("berzaga.jpg")
                    .alcohol(5.0)
                    .color("Tostada")
                    .categoria("Amber Ale")
                    .descripcion("Cerveza artesana tostada al estilo Inglés. Fácil de beber y baja carbonatación. Elaborada con una selección de cuatro maltas, muestra cierto dulzor inicial seguido de un sabor caramelizado que finaliza con toques tostados y un suave amargor en boca, fruto de los lúpulos balanceados en tiempo de cocción.")
                    .build(),
            Cerveza.builder()
                    .nombre("Tormenta Solar")
                    .imagen("baixer-tormenta-solar.jpg")
                    .alcohol(6.5)
                    .color("Naranja pálido")
                    .categoria("Saison")
                    .descripcion("Cerveza de estilo Saison con auténtica levadura Saison. Estilo tipicamente belga de granja, en este caso con lúpulo neozelandés Nelson Sauvín, una combinación interesante de los sabores afrutados aportados por la levadura y los sabores y aromas tropicales y de vino blanco de este lúpulo, añadido en whirpool.")
                    .build(),
            Cerveza.builder()
                    .nombre("Perraborracha")
                    .imagen("perraborracha.png")
                    .alcohol(4.6)
                    .color("Ambar")
                    .categoria("American Pale Ale")
                    .descripcion("American Pale Ale fresquita y sin complicaciones, amarga poco y es muy fácil de beber.")
                    .build(),
            Cerveza.builder()
                    .nombre("Barreno")
                    .imagen("barreno.png")
                    .alcohol(8.8)
                    .color("Negra")
                    .categoria("Stout")
                    .descripcion("Cerveza negra, con aromas y sabor a café, regaliz, chocolate toque licoroso que da paso a ligero lúpulo. Cuerpo medio-completo. Amarga.")
                    .build()

    );

    List<Nota> notas = Arrays.asList(
            Nota.builder()
                    //   .id(1L)
                    .usuario( listaUsuarios.get(0))
                    .titulo("Sobrevalorada cerveza")
                    .contenido("La cerveza en sí no está mal, pero demasiada fama para lo que es")
                    .notaPublica(Boolean.TRUE)
                    .cerveza( listaCervezas.get(0) )
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
        notasRepo.save( notas.get(0) );
        cargadorImagenes();
    }
}
