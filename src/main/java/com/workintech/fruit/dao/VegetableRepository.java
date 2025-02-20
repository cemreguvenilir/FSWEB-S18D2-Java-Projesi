package com.workintech.fruit.dao;

import com.workintech.fruit.entity.Fruit;
import com.workintech.fruit.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> getByPriceDesc();
    @Query("SELECT v FROM Vegetable v ORDER BY v.price" )
    List<Vegetable> getByPriceAsc();
    @Query("SELECT v FROM Vegetable v WHERE v.name ilike %:name%")
    List<Vegetable> getByName(String name);
}
