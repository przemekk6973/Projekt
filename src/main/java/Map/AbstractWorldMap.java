package Map;

import Core.Config;
import Core.IPositionChangeObserver;
import Core.Vector2d;
import Objects.Animal;
import Objects.Plant;
import Simulation.IDayChangeAction;

import java.util.*;

public abstract class AbstractWorldMap implements IDayChangeAction,IWorldMap, IPositionChangeObserver {
    protected final int width;
    protected final int height;

    private int startNumOfPlants;

    private int growPlantEachDay;

    protected Config config;
    protected HashMap<Vector2d, List<Animal>> animals = new HashMap<>();
    protected HashMap<Vector2d, Plant> plants = new HashMap<>();


    public AbstractWorldMap(int width, int height, int startNumOfPlants, int growPlantEachDay, Config config) {
        this.width = width;
        this.height = height;
        this.startNumOfPlants = startNumOfPlants;
        this.growPlantEachDay = growPlantEachDay;
        this.config = config;
        generatePlantsOnStart(startNumOfPlants);

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

    //@Override
//    public boolean isOccupied(Vector2d position) {
//        return this.objectAt(position) != null;
//    }
//
//    @Override
//    public IMapElement objectAt(Vector2d position) {
//        //throw jest nie ma
//        if (animals.containsKey(position))
//        {
//            return animals.get(position);
//        }
//        else if (plants.containsKey(position)) {
//            return plants.get(position);
//        }
//        return null;
//
//
//
//    }
    public  void OnPassingDay()
    {
        cleanMap();

    }
    public void cleanMap()
    {

        for(List<Animal> animalsOnPosition: animals.values())
        {
            for(Animal animal : animalsOnPosition ) {
                if (!animal.getAlive()) {
                    //dodaj hash i eq
                    animals.remove(animal.getPosition());
                }

            }

        }

    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,Animal animal) {

        List<Animal> animalSamePositions = animals.get(oldPosition);
        int index = animalSamePositions.indexOf(animal);
        //Dokończ metode
        //animals.computeIfAbsent(newPosition, k -> new ArrayList<>()).add(newPosition);
//
//        animals.remove(oldPosition);
//        animals.put(newPosition,animal);
    }

    @Override
    public Map<Vector2d,List<Animal>> getAnimals() {
        return Collections.unmodifiableMap(animals);
    }

}
