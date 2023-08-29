package com.workintech.fruit.services;

import com.workintech.fruit.dao.VegetableRepository;
import com.workintech.fruit.entity.Fruit;
import com.workintech.fruit.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getAll() {
        return vegetableRepository.findAll();
    }
    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByName(String name) {
        return vegetableRepository.getByName(name);
    }

    @Override
    public Vegetable getById(int id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()){
            return vegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }
}
