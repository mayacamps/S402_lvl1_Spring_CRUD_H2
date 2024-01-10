package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.domain.Fruit;
import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n01.services.impl.FruitServiceImplementation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    @Autowired
    FruitServiceImplementation fruitServiceImp;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        List<Fruit> fruits = fruitServiceImp.getAllFruits();

        if (fruits.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Fruit fruit){
        if (fruitServiceImp.addFruit(fruit)) {
            return new ResponseEntity<>("Added correctly.", HttpStatus.OK);
        }
        return null;
    }


}