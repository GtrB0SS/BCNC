package com.springBoot.bcncapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.bcncapp.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    //List<Photo> findByAlbumId(Long albumId);
}
