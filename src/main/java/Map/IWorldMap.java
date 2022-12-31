package Map;

import Core.IPositionChangeObserver;
import Core.Vector2d;
import Objects.Animal;
import Objects.IMapElement;
import Objects.Plant;
import Simulation.IDayChangeAction;

import java.util.List;
import java.util.Map;

public interface IWorldMap extends IPositionChangeObserver, IDayChangeAction {
    //dodaj z abstracta


    //boolean isOccupied(Vector2d position);
    //IMapElement objectAt(Vector2d position);
    Vector2d newAnimalPosition(Vector2d position,Animal animal);
    void putAnimalOnMap(Animal animal);

    IMapElement objectsAt(Vector2d position);

    int getHeight();

    int getWidth();
    void removePlantFromMap(Vector2d Position);
    Map<Vector2d, List<Animal>> getAnimals();
    Map<Vector2d, Plant> getPlants();

}
