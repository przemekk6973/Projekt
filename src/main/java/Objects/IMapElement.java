package Objects;

import Core.Vector2d;
import Gui.GuiElementBox;

import java.io.FileNotFoundException;

public interface IMapElement {

    //Interfejs - position, resourcepath plików do obiektów


    String getResources();

    Vector2d getPosition();

    GuiElementBox getToDisplay();

    default GuiElementBox loadImg()
    {
        try {
            return  new GuiElementBox(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
