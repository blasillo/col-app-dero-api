package es.jcyl.eclap.api.colapp.servicios;

import es.jcyl.eclap.api.colapp.persistencia.entidades.Imagen;
import es.jcyl.eclap.api.colapp.persistencia.repositorios.ImagenesRepo;
import es.jcyl.eclap.api.colapp.utiles.ImagenUtiles;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ImagenServicio {

    @Autowired
    private final ImagenesRepo imagenesRepo;


    public final String directorioAlmacenamiento = "";



    public byte[] descargarImagen (String imageName) {
        Optional<Imagen> dbImage = imagenesRepo.findByNombre(imageName);
        return dbImage.map(image -> {
            try {
                return ImagenUtiles.decomprimirImagen (image.getDatos());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error descargando imagen", exception)
                        .addContextValue("Imagen ID ",  image.getId())
                        .addContextValue("Imagen nombre", imageName);
            }
        }).orElse(null);
    }




    public String cargarImagen (MultipartFile imageFile) throws IOException {
        Imagen imagen = Imagen.builder()
                .nombre(imageFile.getOriginalFilename())
                .tipo(imageFile.getContentType())
                .datos(ImagenUtiles.comprimirImagen(imageFile.getBytes()))
                .build();

        imagenesRepo.save(imagen);
        return "archivo cargado correctamente : " + imageFile.getOriginalFilename();
    }


    public  byte[] recuperaImagen (String nombre) throws IOException {
        Object storageDirectoryPath = null;
        Path destination = Paths.get(directorioAlmacenamiento+"\\"+nombre);

        return IOUtils.toByteArray(destination.toUri());
    }


}
