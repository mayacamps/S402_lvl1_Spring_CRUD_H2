package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;

import java.util.List;

public interface FruitService {
    public List<Fruit> getAllFruits();
    public Fruit getFruit(int id);
    public void addFruit(Fruit fruit);
    public void updateFruit(int id, Fruit newFruit);
    public void deleteFruit(int id);

}
