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
        List<Animal> moved = new ArrayList<Animal>();
        Map<Vector2d, List<Animal>> copyAnimals = new HashMap<>(map.getAnimals());
        for(List<Animal> animalsOnPosition : copyAnimals.values() )
        {
            List<Animal> animalsCopy = new ArrayList<>(animalsOnPosition);

            for (Animal animal : animalsCopy) {
                if (!moved.contains(animal)) {
                    //System.out.println("Przemieszczam się z " + animal.getPosition());
                    animal.move(animal.getGenome().getBehaviour()[animal.getGenome().getPointerToCurrentGen()]);
                    //System.out.println("Przemieszczam się do " + animal.getPosition());
                    moved.add(animal);
                    //System.out.println(animal.getEnergy());
                }
            }


        }

    }
}
