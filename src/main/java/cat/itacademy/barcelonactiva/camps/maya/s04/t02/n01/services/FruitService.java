package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;

import java.util.List;

public interface FruitService {
    public List<Fruit> getAllFruits();
    public Fruit getFruit(int id);
    public boolean addFruit(Fruit fruit);
    public boolean updateFruit(int id, Fruit newFruit);
    public boolean deleteFruit(int id);

}
