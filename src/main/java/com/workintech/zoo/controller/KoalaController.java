package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping
    public List<Koala> find() {
        return this.koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable("id") Integer id) {
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala Koala) {
        koalas.put(Koala.getId(), Koala);
        return koalas.get(Koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable("id") Integer id, @RequestBody Koala Koala) {
        Koala.setId(id);
        if (koalas.containsKey(id)) {
            koalas.put(id, Koala);
            return koalas.get(id);
        } else {
            return save(Koala);
        }
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable("id") Integer id) {
        return koalas.remove(id);
    }
    
}
