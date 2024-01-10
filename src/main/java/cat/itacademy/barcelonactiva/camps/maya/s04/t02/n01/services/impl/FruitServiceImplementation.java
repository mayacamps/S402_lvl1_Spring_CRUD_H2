package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services.impl;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;
import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.repository.FruitRepository;
import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services.FruitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FruitServiceImplementation implements FruitService {

    @Autowired
    FruitRepository fruitRepo;

    @Override
    public List<Fruit> getAllFruits() {
        return new ArrayList<Fruit>(fruitRepo.findAll());
    }

    @Override
    public Fruit getFruit(int id) {
        Optional<Fruit> fruit = fruitRepo.findById(id);
        return fruit.orElse(null);
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        fruitRepo.save(new Fruit(fruit.getName(), fruit.getQuantKilos()));
        return true;
    }

    @Override
    public boolean updateFruit(int id, Fruit newFruit) {
        Optional<Fruit> oldFruit = fruitRepo.findById(id);
        if (oldFruit.isPresent()){
            Fruit updatedFruit = oldFruit.get();
            updatedFruit.setName(newFruit.getName());
            updatedFruit.setQuantKilos(newFruit.getQuantKilos());
            fruitRepo.save(updatedFruit);
            return true;
        } else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public boolean deleteFruit(int id) {
        Optional<Fruit> fruitToDelete = fruitRepo.findById(id);
        if (fruitToDelete.isPresent()) {
            fruitRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
