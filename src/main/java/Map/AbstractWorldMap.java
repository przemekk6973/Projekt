package Map;

import Core.Config;
import Core.IPositionChangeObserver;
import Core.Vector2d;
import Objects.Animal;
import Objects.Plant;
import Simulation.IDayChangeAction;

import javax.swing.text.Position;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final int width;
    protected final int height;

    private int startNumOfPlants;

    private int growPlantEachDay;

    protected Config config;
    protected Map<Vector2d, List<Animal>> animals = new HashMap<>();
    protected Map<Vector2d, Plant> plants = new HashMap<>();


    public AbstractWorldMap(int width, int height, int startNumOfPlants, int growPlantEachDay, Config config) {
        this.width = width;
        this.height = height;
        this.startNumOfPlants = startNumOfPlants;
        this.growPlantEachDay = growPlantEachDay;
        this.config = config;
        generatePlantsOnStart(startNumOfPlants);

        //testowe usun


        Plant plant = new Plant(new Vector2d(2,3));
        plants.put(plant.getPosition(),plant);

    }
    //w losowym miejscu generują się roślinki
    private void generatePlantsOnStart(int numOfPlants)
    {
        Random rand = new Random();
        List<Vector2d> Combinations = new ArrayList<>();
        for (int x = 0; x < numOfPlants; x++) {
            for (int y = 0; y < numOfPlants; y++) {
                Combinations.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(Combinations);
        for (int i = 0; i < numOfPlants; i++) {
            plants.put(Combinations.get(i),new Plant(Combinations.get(i)));
        }

    }


    public  void OnPassingDay()
    {
        cleanMap();

    }
    public void cleanMap()
    {


        //popraw strimy tak samor reszta
        HashMap<Vector2d,List<Animal>> copyAnimals = new HashMap<>(animals);
        for(List<Animal> animalsOnPosition: copyAnimals.values())
        {
            List <Animal> copyAnimalsOnPosition = new ArrayList<>(animalsOnPosition);
            for(Animal animal : copyAnimalsOnPosition ) {
                if (!animal.getAlive()) {
                    //dodaj hash i eq
                    animals.remove(animal.getPosition());
                }

            }

        }

    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,Animal animal) {

//        if(animalToAddNewAnimal == null)
//        {
//            animalToAddNewAnimal = new ArrayList<Animal>();
//            animals.put(newPosition,animalToAddNewAnimal);
//
//        }
//        animalToAddNewAnimal.add(animal);


        List<Animal> animalSamePositions = animals.get(oldPosition);
        animalSamePositions.remove(animal);;
        List<Animal> animalToAddNewAnimal = animals.get(newPosition);
        if(animalToAddNewAnimal == null)
        {
            animalToAddNewAnimal = new ArrayList<Animal>();
            animals.put(newPosition,animalToAddNewAnimal);

        }
        animalToAddNewAnimal.add(animal);
    }

    @Override
    public Map<Vector2d,List<Animal>> getAnimals() {
        return Collections.unmodifiableMap(animals);
    }

    public Map<Vector2d,Plant> getPlants() {
        return Collections.unmodifiableMap(plants);
    }

    public void putAnimalOnMap(Animal animal)
    {
        List<Animal> onSamePosition = animals.get(animal.getPosition());
        if (onSamePosition == null)
        {
            onSamePosition = new ArrayList<Animal>();
            animals.put(animal.getPosition(),onSamePosition);
        }
        onSamePosition.add(animal);

    }

    public void removePlantFromMap(Vector2d position)
    {
        plants.remove(position);

    }

}
