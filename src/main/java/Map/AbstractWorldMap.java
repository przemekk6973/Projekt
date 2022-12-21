package Map;

import Core.Vector2d;
import Objects.Animal;
import Objects.Plant;

import java.util.*;

public class AbstractWorldMap implements IWorldMap {
    private final int width;
    private final int height;

    private int startNumOfPlants;

    private int growPlantEachDay;

    protected HashMap<Vector2d, Animal> animals = new HashMap<>();
    protected HashMap<Vector2d, Plant> plants = new HashMap<>();


    public AbstractWorldMap(int width,int height,int startNumOfPlants,int growPlantEachDay) {
        this.width = width;
        this.height = height;
        this.startNumOfPlants = startNumOfPlants;
        this.growPlantEachDay = growPlantEachDay;
        generatePlantsOnStart(startNumOfPlants);

    }

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
    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
