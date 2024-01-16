package com.springBoot.bcncapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Photo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cambia el nombre lógico a "albumId" y utiliza @JoinColumn para especificar el nombre físico
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    private String title;
    private String url;
    private String thumbnailUrl;
    
    
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Photo(Long id, Album album, String title, String url, String thumbnailUrl) {
		super();
		this.id = id;
		this.album = album;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
    
    
}
