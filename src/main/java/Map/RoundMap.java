package Map;

import Core.Config;
import Core.Vector2d;
import Objects.Animal;

public class RoundMap extends AbstractWorldMap {


    public RoundMap(int width, int height, int startNumOfPlants, int growPlantEachDay, Config config) {
        super(width, height, startNumOfPlants, growPlantEachDay, config);
    }

    @Override
    public Vector2d newAnimalPosition(Vector2d position, Animal animal) {
        if (position.getX() > width) {
            return new Vector2d(0, position.getY());

        } else if (position.getX() < 0) {
            return new Vector2d(width, position.getY());
        } else if (position.getY() > height || position.getY() < 0) {
            animal.setOrientation(animal.getOrientation().reverse());
            return position;
        }

            return position;


    }
}
