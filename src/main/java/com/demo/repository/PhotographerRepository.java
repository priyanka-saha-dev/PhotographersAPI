package com.demo.repository;

import com.demo.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {

    // Custom query to find all users who are photographers
    List<Photographer> findByEventTypes_EventIn(List<String> eventTypes);
}
