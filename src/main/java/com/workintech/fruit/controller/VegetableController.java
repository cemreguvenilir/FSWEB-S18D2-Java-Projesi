package com.workintech.fruit.controller;

import com.workintech.fruit.entity.Fruit;
import com.workintech.fruit.entity.Vegetable;
import com.workintech.fruit.exceptions.FruitException;
import com.workintech.fruit.services.VegetableService;
import com.workintech.fruit.services.VegetableServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
@Validated
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }
    @GetMapping("/")
    public List<Vegetable> get(){
        return vegetableService.getAll();
    }
    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }
    @GetMapping("/asc")
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }
    @PostMapping("/{name}")
    public List<Vegetable> getByName(@PathVariable String name){
        return vegetableService.getByName(name);
    }
    @GetMapping("/{id}")
    public Vegetable getById(@Positive @PathVariable int id){
        Vegetable vegetable = vegetableService.getById(id);
        if(vegetable ==null){
            throw new FruitException("vegetable with given id is not exist", HttpStatus.NOT_FOUND);
        }
        return vegetable;
    }
    @PostMapping("/")
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable int id){
        Vegetable vegetable = vegetableService.getById(id);
         vegetableService.delete(vegetable);
         return vegetable;

    }
}
