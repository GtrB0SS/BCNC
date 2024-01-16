package com.springBoot.bcncapp.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.springBoot.bcncapp.entities.Album;
import com.springBoot.bcncapp.entities.Photo;
import com.springBoot.bcncapp.repositories.AlbumRepository;
import com.springBoot.bcncapp.repositories.PhotoRepository;
import com.springBoot.bcncapp.services.DataServiceImpl;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataServiceImpl {
	
	 


 @Autowired
 private DataServiceImpl dataService;

 @MockBean
 private AlbumRepository albumRepository;

 @MockBean
 private PhotoRepository photoRepository;
 
 

 
 
 

 @Test
 public void testEnrichAlbumsWithPhotos() {
	 
     // Lógica de prueba para el enriquecimiento de álbumes con fotos

	// Configurar datos de prueba
     Album album1 = new Album(1L, 1L, "Album 1", null);  // null para photos ya que serán enriquecidas
     Album album2 = new Album(2L, 1L, "Album 2", null);

     Photo photo1 = new Photo(1L, album1, "Photo 1", "url1", "thumbnail1");
     Photo photo2 = new Photo(2L, album1, "Photo 2", "url2", "thumbnail2");
     List<Photo> photos = Arrays.asList(photo1, photo2);

     // Configurar comportamiento de los repositorios mock
     when(albumRepository.findAll()).thenReturn(Arrays.asList(album1, album2));
     when(photoRepository.findAll()).thenReturn(photos);

     // Ejecutar el método bajo prueba
     List<Album> enrichedAlbums = dataService.enrichAlbumsWithPhotos();

     // Verificar el resultado esperado
     assertEquals(2, enrichedAlbums.size());
     assertEquals(2, enrichedAlbums.get(0).getPhotos().size());
     // Agrega más aserciones según la lógica de tu aplicación

     // Verificar que los métodos del repositorio se hayan llamado correctamente
     verify(albumRepository, times(1)).findAll();
     verify(photoRepository, times(1)).findAll();
 }
 
//Método auxiliar para enriquecer álbumes con fotos
private List<Album> enrichAlbumsWithPhotos(List<Album> albums, List<Photo> photos) {
  // Implementa la lógica para enriquecer cada álbum con sus respectivas fotos
  // Puedes adaptar esto según la lógica real de tu aplicación
  // Aquí simplemente asignamos la lista de fotos a cada álbum
  for (Album album : albums) {
      album.setPhotos(photos.stream().filter(photo -> photo.getAlbum().equals(album)).collect(Collectors.toList()));
  }
  return albums;
}

 @Test
 public void testEnrichPhotosWithoutDatabase() {
     // Lógica de prueba para el enriquecimiento de fotos sin usar la base de datos
	 
	 
	 // Configurar datos de prueba
	    List<Album> albums = Arrays.asList(
	            new Album(1L, 1L, "Album 1", null),
	            new Album(2L, 1L, "Album 2", null)
	    );

	 // Configurar comportamiento del servicio de datos mock
        when(dataService.enrichPhotosWithoutDatabase()).thenReturn(
                albums.stream().map(album -> {
                    Photo photo = new Photo();
                    // Configurar propiedades de la foto según tus necesidades
                    return photo;
                }).collect(Collectors.toList())
        );

        // Configurar comportamiento del repositorio de fotos mock
        when(photoRepository.findAll()).thenReturn(Arrays.asList(
                new Photo(1L, albums.get(0), "Photo 1", "url1", "thumbnail1"),
                new Photo(2L, albums.get(0), "Photo 2", "url2", "thumbnail2"),
                new Photo(3L, albums.get(1), "Photo 3", "url3", "thumbnail3")
        ));

        // Ejecutar el método bajo prueba
        List<Photo> enrichedPhotos = dataService.enrichPhotosWithoutDatabase();

        // Lógica específica para el enriquecimiento de fotos sin usar la base de datos
        //dataService.enrichPhotosWithoutDatabase(enrichedPhotos);
        
        

        // Verificar el resultado esperado después de aplicar la lógica
        //assertEquals("Title should be 'Photo 1'", "Photo 1", enrichedPhotos.get(0).getTitle());
        //assertEquals("Title should be 'Photo 2'", "Photo 2", enrichedPhotos.get(1).getTitle());
        //assertEquals("Title should be 'Photo 3'", "Photo 3", enrichedPhotos.get(2).getTitle());
        



        String actualTitle = enrichedPhotos.get(0).getTitle();
        if (!"Photo 1".equals(actualTitle)) {
            fail("Title should be 'Photo 1', but it is: " + actualTitle);
        }

        
        String actualTitle2 = enrichedPhotos.get(1).getTitle();
        if (!"Photo 2".equals(actualTitle2)) {
            fail("Title should be 'Photo 2', but it is: " + actualTitle2);
        }

        
        String actualTitle3 = enrichedPhotos.get(2).getTitle();
        if (!"Photo 3".equals(actualTitle3)) {
            fail("Title should be 'Photo 3', but it is: " + actualTitle3);
        }


        // Verificar que el método del servicio de datos y del repositorio de fotos se hayan llamado correctamente
        verify(dataService, times(1)).enrichPhotosWithoutDatabase();
        verify(photoRepository, times(1)).findAll();
 }
 
 @Test
 public void testGetAllAlbumsFromDatabase() {
     // Lógica de prueba para obtener todos los álbumes desde la base de datos
	 
	// Configurar datos de prueba
     List<Album> albumsFromDatabase = Arrays.asList(
    		 new Album(1L, 1L, "Album 1", null),
             new Album(2L, 1L, "Album 2", null)
     );

     // Configurar comportamiento del repositorio de álbumes mock
     when(albumRepository.findAll()).thenReturn(albumsFromDatabase);

     // Ejecutar el método bajo prueba
     List<Album> result = dataService.getAllAlbumsFromDatabase();

     // Verificar el resultado esperado
     assertEquals(albumsFromDatabase, result, "Your custom message");

     // Verificar que el método del repositorio de álbumes se haya llamado correctamente
     verify(albumRepository, times(1)).findAll();
 }
}
