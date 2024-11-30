package com.demo.controller;

import com.demo.entity.Photographer;
import com.demo.service.PhotographersService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/photographers")
@Slf4j
public class PhotographersController {

    private final PhotographersService service;

    public PhotographersController(PhotographersService service) {
        this.service = service;
    }


    @PostMapping(
            consumes = "application/json"
    )
    public ResponseEntity<Boolean> upload(@RequestBody List<Photographer> photographers) {
        Boolean status = this.service.upload(photographers);
        return ResponseEntity.ok(status);
    }

    @GetMapping(
            value = "/check",
            produces = "application/json"
    )
    public ResponseEntity<Boolean> check() {
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<List<Photographer>> getAllPhotographers() {
        List<Photographer> photographers = this.service.getAllPhotographers();
        return ResponseEntity.ok(photographers);
    }

    @GetMapping(
            value = "/events/{events}",
            produces = "application/json"
    )
    public ResponseEntity<List<Photographer>> getAllPhotographersByEvent(@PathVariable("events") String eventTypes) {
        List<String> events = Arrays.stream(eventTypes.split(",")).toList();
        List<Photographer> photographers = this.service.getAllPhotographersByEvent(events);
        return ResponseEntity.ok(photographers);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<Photographer> getPhotographerById(@PathVariable("id") String id) {
        Optional<Photographer> photographer = this.service.getPhotographerById(Integer.valueOf(id));
        return photographer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(
            produces = "application/json"
    )
    public ResponseEntity<Boolean> deleteAll() {
        this.service.clearAll();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

//
//    @GetMapping
//    public CollectionModel<EntityModel<TaskDto>> getAllTasks() {
//        List<TaskDto> tasks = fetchAllTasks(); // Assume this fetches the tasks
//
//        List<EntityModel<TaskDto>> taskModels = tasks.stream().map(task -> {
//            EntityModel<TaskDto> taskModel = EntityModel.of(task);
//            taskModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
//                    .getTask(task.getId())).withSelfRel());
//            taskModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
//                    .getComments(task.getId())).withRel("comments"));
//            return taskModel;
//        }).toList();
//
//        return CollectionModel.of(taskModels, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
//                .getAllTasks()).withSelfRel());
//    }
}
