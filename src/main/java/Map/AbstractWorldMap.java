package Map;

import Core.Config;
import Core.Vector2d;
import Objects.Animal;
import Objects.Plant;
import  Objects.IMapElement;

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



    }
    //w losowym miejscu generują się roślinki
    private void generatePlantsOnStart(int numOfPlants)
    {
        List<Vector2d> Combinations = new ArrayList<>();
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Combinations.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(Combinations);
        for (int i = 0; i < numOfPlants; i++) {
            plants.put(Combinations.get(i),new Plant(Combinations.get(i)));
        }
        System.out.println("Wielkosc" + plants.size());

    }


    public  void OnPassingDay()
    {
        cleanMap();

    }
    public void cleanMap()
    {
        HashMap<Vector2d,List<Animal>> copyAnimals = new HashMap<>(animals);

        for(Vector2d animalsPosition: copyAnimals.keySet())
        {
            List<Animal> animalsOnPosition = new ArrayList<>(animals.get(animalsPosition));

            for(Animal animal: animalsOnPosition)
            {
                if (!animal.getAlive()) {
                    //dodaj hash i eq
                    animals.get(animalsPosition).remove(animal);
                    System.out.println(animals.get(animalsPosition).size());

                }


            }


        }



        //popraw strimy tak samor reszta

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

    public IMapElement objectsAt(Vector2d position) {
        //DO ZMIANY

        if (animals.get(position) != null && animals.get(position).size() > 0)
        {
            return animals.get(position).get(0);
        }
        if(plants.get(position) != null)
        {

            return plants.get(position);
        }

        //POPRAW BO GDY DODASZ NOWY ELEMENT NA MAPE NIE BEDZIE BLEDU!

        return null;



    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
