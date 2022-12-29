package animalmanagement;

import Core.Vector2d;
import Map.IWorldMap;
import Objects.Animal;
import Simulation.IDayChangeAction;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movement implements IDayChangeAction {


    private IWorldMap map;

    public Movement(IWorldMap map)
    {
        this.map = map;


    }
    @Override
    public void OnPassingDay() {
        //popraw iteratorem potem
        Map<Vector2d, List<Animal>> animals = new HashMap<>(map.getAnimals());
        for(List<Animal> animalsOnPosition : animals.values() )
        {
            List<Animal> animalsCopy = new ArrayList<>(animalsOnPosition);

            for (Animal animal : animalsCopy) {
                animal.move(animal.getGenome().getBehaviour()[animal.getGenome().getPointerToCurrentGen()]);
            }


        }

    }
}
