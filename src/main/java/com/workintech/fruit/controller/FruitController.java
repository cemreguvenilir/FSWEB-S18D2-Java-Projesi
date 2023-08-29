package com.workintech.fruit.controller;

import com.workintech.fruit.entity.Fruit;
import com.workintech.fruit.exceptions.FruitException;
import com.workintech.fruit.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@Validated
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @GetMapping("/")
    public List<Fruit> get(){
        return fruitService.getAll();
    }
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }
    @GetMapping("/asc")
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }
    @PostMapping("/{name}")
    public List<Fruit> getByName(@PathVariable String name){
        return fruitService.getByName(name);
    }
    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id){
        Fruit fruit = fruitService.getById(id);
        if(fruit == null){
            throw new FruitException("fruit with given id is not exist", HttpStatus.NOT_FOUND);
        }
        return fruit;
    }
    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id){
        Fruit fruit = fruitService.getById(id);
        fruitService.delete(fruit);
        return fruit;
    }
}
