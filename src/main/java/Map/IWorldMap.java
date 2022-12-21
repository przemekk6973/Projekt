package Map;

import Core.Vector2d;
import Objects.Animal;

public interface IWorldMap {


    boolean canMoveTo(Vector2d position);

    boolean place(Animal animal);

    boolean isOccupied(Vector2d position);


    Object objectAt(Vector2d position);

}
