package com.example.mslabspringboottest.controller;

import com.example.mslabspringboottest.model.LabSystem;
import com.example.mslabspringboottest.service.LabService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabController {
    private final LabService service;

    public LabController(LabService service) {
        this.service = service;
    }
    @GetMapping("/checkConnection")
    public String check(){
        return "Connected";
    }
    @GetMapping("/getAll")
    public List<LabSystem> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public LabSystem getSystem(@PathVariable String id){
        return service.getSystem(id);
    }

    @PostMapping("/addSystem")
    public LabSystem addSystem(@RequestBody LabSystem system){
        return service.create(system);
    }

    @PutMapping("/update/{id}")
    public LabSystem update(@RequestBody LabSystem system,@PathVariable String id){
        return service.update(system,id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSystem(@PathVariable String id){
        service.deleteSystem(id);
    }
}
