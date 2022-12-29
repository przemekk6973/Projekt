package Gui;

import Objects.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private Image image;

    private ImageView imageView;

    private IMapElement element;



    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        this.element = element;
        this.image = new Image(new FileInputStream(element.getResources()));

        //this.image = new Image(new FileInputStream(element.getResources()));
    }
    //Wczytywanie plików, dostosowywanie wymiarów itd.

    public VBox getImageView() throws FileNotFoundException {
        return null;
    }

}
