package com.workintech.fruit.services;

import com.workintech.fruit.entity.Fruit;
import com.workintech.fruit.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getAll();
    List<Vegetable> getByPriceDesc();
    List<Vegetable> getByPriceAsc();
    List<Vegetable> getByName(String name);
    Vegetable getById(int id);
    Vegetable save(Vegetable vegetable);
    void delete(Vegetable vegetable);
}
