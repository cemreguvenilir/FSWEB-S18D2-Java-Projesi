package com.workintech.fruit.services;

import com.workintech.fruit.dao.FruitRepository;
import com.workintech.fruit.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getAll();
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> getByName(String name);
    Fruit getById(int id);
    Fruit save(Fruit fruit);
    void delete(Fruit fruit);


}
