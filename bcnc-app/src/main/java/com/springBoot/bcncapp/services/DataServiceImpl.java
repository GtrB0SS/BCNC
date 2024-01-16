package com.springBoot.bcncapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springBoot.bcncapp.entities.Album;
import com.springBoot.bcncapp.entities.Photo;
import com.springBoot.bcncapp.repositories.AlbumRepository;
import com.springBoot.bcncapp.repositories.PhotoRepository;

//DataServiceImpl.java
//DataServiceImpl.java
@Service
public class DataServiceImpl implements DataService {

 @Autowired
 private AlbumRepository albumRepository;

 @Autowired
 private PhotoRepository photoRepository;
 
 @Autowired
 private RestTemplate restTemplate;

 private static final String ALBUMS_API_URL = "https://jsonplaceholder.typicode.com/albums";
 private static final String PHOTOS_API_URL = "https://jsonplaceholder.typicode.com/photos";

 @Override
 public List<Album> enrichAlbumsWithPhotos() {
     List<Album> albums = fetchAlbums();
     List<Photo> photos = fetchPhotos();

     for (Album album : albums) {
         List<Photo> albumPhotos = photos.stream()
                 .filter(photo -> photo.getId().equals(album.getId()))
                 .collect(Collectors.toList());
         album.setPhotos(albumPhotos);
     }

     albumRepository.saveAll(albums);
     return albums;
 }

 @Override
 public List<Photo> enrichPhotosWithoutDatabase() {
     List<Album> albums = fetchAlbums();
     List<Photo> photos = fetchPhotos();

     for (Album album : albums) {
         List<Photo> albumPhotos = photos.stream()
                 .filter(photo -> photo.getId().equals(album.getId()))
                 .collect(Collectors.toList());
         album.setPhotos(albumPhotos);
     }

     return photos;
 }

 @Override
 public List<Album> getAllAlbumsFromDatabase() {
     return albumRepository.findAll();
 }

 private List<Album> fetchAlbums() {
    // Lógica para obtener álbumes desde el API ALBUMS_API_URL
	Album[] albumsArray = restTemplate.getForObject(ALBUMS_API_URL, Album[].class);
    return Arrays.asList(albumsArray);
	
 }

 private List<Photo> fetchPhotos() {
    // Lógica para obtener fotos desde el API PHOTO_API_URL
	 Photo[] photosArray = restTemplate.getForObject(PHOTOS_API_URL, Photo[].class);
	 return Arrays.asList(photosArray);
 }
}


