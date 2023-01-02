package Gui;

import Objects.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
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
        //obsluz
        this.image = new Image(new FileInputStream(element.getResources()));
        this.imageView = new ImageView(image);
    }
    //Wczytywanie plików, dostosowywanie wymiarów itd.

    public ImageView getImage()  {



        return imageView;

    }

}
