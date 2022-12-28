package animalmanagement;

import Map.IWorldMap;
import Objects.Animal;
import Simulation.IDayChangeAction;

import java.util.List;

public class AnimalMovement implements IDayChangeAction {


    private IWorldMap map;

    public AnimalMovement(IWorldMap map)
    {
        this.map = map;


    }
    @Override
    public void OnPassingDay() {
        for(List<Animal> animalsOnPosition : map.getAnimals().values() )
        {
            for(Animal animal :animalsOnPosition ) {
                animal.move(animal.getGenome().getBehaviour()[animal.getGenome().getPointerToCurrentGen()]);

            }
        }

    }
}
