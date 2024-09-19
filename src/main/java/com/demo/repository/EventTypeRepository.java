package com.demo.repository;

import com.demo.entity.EventType;
import com.demo.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {
    Optional<EventType> findByEvent(String event);
}
