package org.transportiq.controllers;

import org.transportiq.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final GenericService genericService;

    @Autowired
    public ApiController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping("/{modelName}/{id}")
    public Map<String, Object> getById(@PathVariable String modelName, @PathVariable Integer id) {
        return genericService.getById(modelName, id).getFields();
    }

    @DeleteMapping("/{modelName}/{id}")
    public void deleteById(@PathVariable String modelName, @PathVariable Long id) {
        System.out.println(modelName + " - " + id);
        genericService.deleteById(modelName, id);
    }

    @PutMapping("/{modelName}/{id}")
    public void update(@PathVariable String modelName, @PathVariable Long id, @RequestBody Map<String, Object> updates) {
        System.out.println(modelName + " - " + id);
        genericService.update(modelName, id, updates);
    }
}
