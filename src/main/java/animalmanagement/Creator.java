package animalmanagement;


import AnimalData.Energy;
import AnimalData.Genome;
import Core.Config;
import Objects.Animal;

public class Creator {


    private Config config;


    public Creator(Config config)
    {
        this.config = config;
    }

    public Boolean canCreateAnimal(Animal animal)
    {
        return animal.getEnergy() >= config.getEnergyReqToCreateAnimal();
    }

    public Animal createNewAnimal(Animal animal1, Animal animal2,DeathSpecter specter)
    {
        //ewentualnie dodac tutaj dla dwoch canCreateAnimal i jesli nie mozna to wyrzucic exception dla pewności że wszystko jest okej
        //albo sprawdzamy na zewnatrz
        Genome newAnimalGenom = new Genome(animal1,animal2,config.getNumOfGenens());
        Energy energy = new Energy(config.getStartEnergy());
        animal1.setAnimalEnergy(animal1.getEnergy() - config.getNumOfGenens());
        animal2.setAnimalEnergy(animal1.getEnergy() - config.getNumOfGenens());
        Animal bornAnimal = new Animal(newAnimalGenom,energy,animal1.getPosition(),animal1.getMap());
        specter.PutDeathSpec(bornAnimal);
        return bornAnimal;

    }
//mozna sprawdzac jeszcze np czy zwierzeta sa na tej samej pozycji zeby móc tworzyć inne zwierze itd






}
