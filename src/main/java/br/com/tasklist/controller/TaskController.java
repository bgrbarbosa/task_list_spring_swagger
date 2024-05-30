package br.com.tasklist.controller;

import br.com.tasklist.entity.dto.TaskDTO;
import br.com.tasklist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<Object>findAll() {
        List<TaskDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        TaskDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<TaskDTO>> findById(@PathVariable String status) {
        List<TaskDTO> dto = service.findByStatus(status);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Object>insert(@RequestBody TaskDTO dto){
        TaskDTO result = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdTask()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO dto) {
        dto = service.update(dto.getIdTask(), dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
