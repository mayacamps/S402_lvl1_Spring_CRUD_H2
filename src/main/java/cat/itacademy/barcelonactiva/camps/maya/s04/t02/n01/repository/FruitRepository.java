package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.repository;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer>{
    Optional<Fruit> findById(int id);
    void deleteById(int id);
}
