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
        // -1 -1


        //-1 0

        if (position.getY() < 0)
        {
            animal.setOrientation(animal.getOrientation().reverse());
            position =  new Vector2d(position.getX(),0); // -1 0
        }

        else if(position.getY()  >= height)
        {
            animal.setOrientation(animal.getOrientation().reverse());
            position =  new Vector2d(position.getX(),width-1);
        }

         if(position.getX() >= width)
        {
            position =  new Vector2d(0,position.getY());

        }

        else if(position.getX() < 0  )
        {
            position=  new Vector2d(width-1, position.getY() );
            // width -1
        }
        //System.out.println("Zwracam" + position);
        return  position;


    }


}
