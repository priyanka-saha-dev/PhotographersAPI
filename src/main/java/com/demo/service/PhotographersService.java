package com.demo.service;

import com.demo.dto.PhotographerDTO;
import com.demo.entity.Photographer;

import java.util.List;
import java.util.Optional;

public interface PhotographersService {

    Boolean upload(List<Photographer> photographers);
    void clearAll();
    List<Photographer> getAllPhotographers();
    List<Photographer> getAllPhotographersByEvent(List<String> eventTypes);
    Optional<Photographer> getPhotographerById(Integer id);

}
