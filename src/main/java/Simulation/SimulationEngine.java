package Simulation;


import AnimalData.Energy;
import AnimalData.Genome;
import Core.Config;
import Core.Vector2d;
import Map.IWorldMap;
import Objects.Animal;
import animalmanagement.Creator;
import animalmanagement.DeathSpecter;
import animalmanagement.Interaction;
import animalmanagement.Movement;
import java.util.*;

import java.util.ArrayList;

public class SimulationEngine {


    //private Creator creator;
    private Config config;
    //private TimeManager timeManager;
    //private Movement movement;
    //private DeathSpecter specter;

    private IWorldMap map;

    public SimulationEngine(Config config,IWorldMap map)
    {
        //this.creator = creator;
        this.config = config;
        this.map = map;
        //this.timeManager = timeManager;
        //this.movement = movement;
        //this.specter =specter;
    }

    public void run()
    {
        int i = 0;
        DeathSpecter specter = new DeathSpecter(config);
        generateAnimals(specter);

        System.out.println("PRZED");
        for(List<Animal> animalList : map.getAnimals().values())
        {
            for(Animal animal: animalList)
            {
                System.out.println("---------------");
                System.out.println(animal.getPosition());
                System.out.println(animal.getEnergy());

                System.out.println("---------------");
            }

            //System.out.println(animalList.size());
        }




        TimeManager timeManager = new TimeManager();
        Creator creator = new Creator(config);
        Movement movement = new Movement(map);

        Interaction interaction = new Interaction(config,map,specter,creator);
        timeManager.loadActions(map);
        timeManager.loadActions(movement);
        timeManager.loadActions(interaction);
        timeManager.loadActions(specter);
        while (i < 80) {
            timeManager.changeDay();
            i+=1;

        }
        System.out.println("PO");
        for(List<Animal> animalList : map.getAnimals().values())
        {
            for(Animal animal: animalList)
            {
                System.out.println("---------------");
                System.out.println(animal.getPosition());
                System.out.println(animal.getEnergy());

                System.out.println("---------------");
            }

            //System.out.println(animalList.size());
        }




    }

    public void generateAnimals(DeathSpecter specter)
    {

          Genome genome = new Genome(config.getNumOfGenens());
          Energy energy = new Energy(config.getStartEnergy());
          Animal animal1 = new Animal(genome,energy,new Vector2d(4,6),map);
         specter.PutDeathSpec(animal1);

          Genome genome2 = new Genome(config.getNumOfGenens());
         Energy energy2 = new Energy(config.getStartEnergy());
         Animal animal2 = new Animal(genome2,energy2,new Vector2d(3,6),map);
        specter.PutDeathSpec(animal2);

         Genome genome3 = new Genome(config.getNumOfGenens());
         Energy energy3 = new Energy(config.getStartEnergy());
         Animal animal3 = new Animal(genome3,energy3,new Vector2d(7,8),map);
        specter.PutDeathSpec(animal3);


//        for(int i=0; i<config.getStartNumberOfAnimal();i++)
//        {
//            Animal animal = new Animal();
//
//
//
//        }
    }



    //opóźnienie ruchu, pauza, statystyki, śledzenie zwierzęcia, licznik elementów,
    // obserwatorzy ruchu i przebiegu dnia symulacji, ruch zwierząt, karmienie zwierząt, usuwanie trupów
    // dodawanie trawy, reprodukcja, wybranie najsilniejszego zwierzęcia, wysyłanie statystyk statystyk itd.

}
