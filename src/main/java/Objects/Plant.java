package Objects;

import Core.Vector2d;
import Gui.GuiElementBox;

import java.io.FileNotFoundException;

public class Plant implements IMapElement  {

    private Vector2d position;
    private GuiElementBox toDisplay;

    public Plant(Vector2d position)  {
            this.position = position;
            toDisplay = loadImg();


    }
    public Vector2d getPosition()
    {
        return this.position;

    }

    @Override
    public String getResources() {
        return "src/main/resources/plant.png";
    }

    public GuiElementBox getToDisplay() {
        return toDisplay;
    }
}
