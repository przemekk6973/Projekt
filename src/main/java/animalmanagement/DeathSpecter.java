package animalmanagement;

import Objects.Animal;
import Simulation.IDayChangeAction;

import java.util.ArrayList;

public class DeathSpecter implements IDayChangeAction {

    private ArrayList<Animal> animalsDestinedToDeath = new ArrayList<Animal>();

    @Override
    public void OnPassingDay() {

        checkForDeath();


    }

    private void checkForDeath()
    {
        for(Animal animal : animalsDestinedToDeath)
        {
            if (animal.getEnergy() <=0)
            {
                animal.setAlive(false);
                animalsDestinedToDeath.remove(animal);
                //zegnaj
            }
        }
    }

    public void PutDeathSpec(Animal animal)
    {
        animalsDestinedToDeath.add(animal);

    }

}
