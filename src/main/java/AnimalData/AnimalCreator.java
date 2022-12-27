package AnimalData;

import Core.Config;
import Objects.Animal;

public class AnimalCreator {


    private Config config;


    public AnimalCreator(Config config)
    {
        this.config = config;
    }

    public Boolean canCreateAnimal(Animal animal)
    {
        return animal.getEnergy() >= config.getEnergyReqToCreateAnimal();
    }

    public Animal createNewAnimal(Animal animal1, Animal animal2)
    {
        //ewentualnie dodac tutaj dla dwoch canCreateAnimal i jesli nie mozna to wyrzucic exception
        //albo sprawdzamy na zewnatrz
        Genome newAnimalGenom = new Genome(animal1,animal2,config.getNumOfGenens());
        Energy energy = new Energy(config.getStartEnergy());
        animal1.setAnimalEnergy(animal1.getEnergy() - config.getNumOfGenens());
        animal2.setAnimalEnergy(animal1.getEnergy() - config.getNumOfGenens());
        return new Animal(newAnimalGenom,energy,animal1.getPosition());

    }
//mozna sprawdzac jeszcze np czy zwierzeta sa na tej samej pozycji zeby móc tworzyć inne zwierze itd






}
