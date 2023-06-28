package es.jcyl.eclap.api.colapp.controladores;

import es.jcyl.eclap.api.colapp.servicios.ImagenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/imagenes")
@RequiredArgsConstructor
public class ImagenControlador {

    @Autowired
    private final ImagenServicio imagenServicio;

    @GetMapping("/{nombre}")
    public ResponseEntity<?> downloadImage(@PathVariable String nombre) {
        byte[] imageData = imagenServicio.descargarImagen(nombre);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .body(imageData);
    }


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("imagen") MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new FileNotFoundException("Proporciona un archivo válido");
        String uploadImage = imagenServicio.cargarImagen(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(uploadImage);
    }


    /*
    @GetMapping( value = "/{nombre}", produces = { MediaType.IMAGE_JPEG_VALUE,
                                                      MediaType.IMAGE_GIF_VALUE,
                                                      MediaType.IMAGE_PNG_VALUE} )
    public @ResponseBody byte[] obtenerImagen (@PathVariable(name = "nombre") String nombre) throws IOException {
        return this.imagenServicio.recuperaImagen(nombre);
    }

     */


}

