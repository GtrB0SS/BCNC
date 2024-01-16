package com.springBoot.bcncapp.services;

import java.util.List;

import com.springBoot.bcncapp.entities.Album;
import com.springBoot.bcncapp.entities.Photo;

public interface DataService {
	List<Album> enrichAlbumsWithPhotos();
    List<Photo> enrichPhotosWithoutDatabase();
    List<Album> getAllAlbumsFromDatabase();

}
