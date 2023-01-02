package Map;


import Core.Config;
import Core.Vector2d;
import Objects.Animal;

import java.util.Random;

public class PortalMap extends AbstractWorldMap {
    public PortalMap(int width, int height, int startNumOfPlants, int growPlantEachDay, Config config) {
        super(width, height, startNumOfPlants, growPlantEachDay, config);
    }

    //kontrola pozycji na mapie tak jakby była portalem


    @Override
    public Vector2d newAnimalPosition(Vector2d position,Animal animal) {
        if (position.getX() >= width || position.getY() >= height || position.getX() < 0 || position.getY() < 0)
        {
            animal.setAnimalEnergy(animal.getEnergy() - config.getEnergyReqToCreateAnimal());;
            return generateNewAnimalPosition();

        }
        else{
            return position;
        }
    }


    private Vector2d generateNewAnimalPosition()
    {
        Random rand = new Random();
        return new Vector2d(rand.nextInt(width-1), rand.nextInt(height-1));


    }



}
