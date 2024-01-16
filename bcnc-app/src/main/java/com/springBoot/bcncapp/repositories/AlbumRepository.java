package com.springBoot.bcncapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.bcncapp.entities.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {

	
}
