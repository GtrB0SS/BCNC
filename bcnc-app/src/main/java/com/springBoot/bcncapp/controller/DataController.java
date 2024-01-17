package com.springBoot.bcncapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.bcncapp.entities.Album;
import com.springBoot.bcncapp.entities.Photo;
import com.springBoot.bcncapp.services.DataService;


@RestController
@RequestMapping("/data")

public class DataController {

 @Autowired
 private DataService dataService;

 @GetMapping("/enrichAlbums")
 public List<Album> enrichAlbumsWithPhotos() {
     return dataService.enrichAlbumsWithPhotos();
 }

 @GetMapping("/enrichPhotos")
 public List<Photo> enrichPhotosWithoutDatabase() {
     return dataService.enrichPhotosWithoutDatabase();
 }

 @GetMapping("/getAlbums")
 public List<Album> getAlbumsFromDatabase() {
     return dataService.getAllAlbumsFromDatabase();
 }
 
}
