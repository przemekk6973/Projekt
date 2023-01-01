package Map;

import Core.Config;
import Core.Vector2d;
import Objects.Animal;
import Objects.Plant;
import  Objects.IMapElement;
import mapmanagement.PlantGenerator;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final int width;
    protected final int height;

    private int startNumOfPlants;

    private int growPlantEachDay;

    protected Config config;

    private PlantGenerator plantGenerator;
    protected Map<Vector2d, List<Animal>> animals = new HashMap<>();
    protected Map<Vector2d, Plant> plants = new HashMap<>();


    public AbstractWorldMap(int width, int height, int startNumOfPlants, int growPlantEachDay, Config config) {
        this.width = width;
        this.height = height;
        this.startNumOfPlants = startNumOfPlants;
        this.growPlantEachDay = growPlantEachDay;
        this.config = config;
        this.plantGenerator = new PlantGenerator(width,height,this);
        plantGenerator.generatePlantsOnStart(startNumOfPlants);



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
                    plantGenerator.markAsDeathField(animal.getPosition());


                }


            }


        }

        plantGenerator.generateToxicCorpes(growPlantEachDay);



        //popraw strimy tak samor reszta

    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,Animal animal) {

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

    public void putPlantOnMap(Vector2d position)
    {

        if (position != null)
            plants.put(position,new Plant(position));


    }
}
