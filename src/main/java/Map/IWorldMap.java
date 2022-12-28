package Map;

import Core.Vector2d;
import Objects.Animal;
import Objects.IMapElement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface IWorldMap {



    //boolean isOccupied(Vector2d position);
    //IMapElement objectAt(Vector2d position);
    Vector2d newAnimalPosition(Vector2d position,Animal animal);
    Map<Vector2d, List<Animal>> getAnimals();


}
