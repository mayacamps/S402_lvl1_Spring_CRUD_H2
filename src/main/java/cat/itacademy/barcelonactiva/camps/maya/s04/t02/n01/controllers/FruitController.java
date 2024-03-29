package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;
import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services.impl.FruitServiceImp;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit/v1")
public class FruitController {
    private final FruitServiceImp fruitServiceImp;

    public FruitController(FruitServiceImp fruitServiceImp) {
        this.fruitServiceImp = fruitServiceImp;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        List<Fruit> fruits = fruitServiceImp.getAllFruits();
        if (fruits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody Fruit fruit) {
        fruitServiceImp.addFruit(fruit);
        return new ResponseEntity<>("Item successfully added.", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") int id){
        Fruit fruit = fruitServiceImp.getFruit(id);
        if (fruit == null){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(fruit,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @Valid @RequestBody Fruit newFruit){
        fruitServiceImp.updateFruit(id, newFruit);
        return ResponseEntity.status(HttpStatus.OK).body("Item successfully updated.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        fruitServiceImp.deleteFruit(id);
        return new ResponseEntity<>("Item successfully deleted.", HttpStatus.OK);
    }
}