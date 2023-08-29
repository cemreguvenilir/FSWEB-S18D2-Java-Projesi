package com.workintech.fruit.dao;

import com.workintech.fruit.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();
    @Query("SELECT f FROM Fruit f ORDER BY f.price")
    List<Fruit> getByPriceAsc();
    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> getByName(String name);
}
