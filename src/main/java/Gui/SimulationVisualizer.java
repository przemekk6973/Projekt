package Gui;

import Core.Vector2d;
import Map.IWorldMap;
import Objects.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SimulationVisualizer {

    //Wyświetla całą symulację, siatkę, zwierzęta, umożliwia wyświetlenie śledzenia zwierzęcia po zatrzymaniu symulacji itd.

    private IWorldMap map;
    private GridPane gridPane;

    public SimulationVisualizer(IWorldMap map)
    {
        this.map = map;
        this.gridPane = new GridPane();
        setSizeOfSingleCell(map.getWidth(),map.getHeight(),64);
        gridPane.setGridLinesVisible(true);
        gridPane.setStyle("-fx-background-color: #CD853F;");

    }


    public GridPane setMap()
    {
        gridPane.requestLayout();
        gridPane.getChildren().retainAll(gridPane.getChildren().get(0));

        int mapHeight = map.getHeight();
        int mapWidth = map.getWidth();

        for(int i=0; i<mapHeight; i++)
        {
            IMapElement object = map.objectsAt(new Vector2d(0,i));
            if (object != null)
            {

                Label label = new Label("");
                label.setGraphic(object.getToDisplay().getImage());
                gridPane.add(label,0,i );
                GridPane.setHalignment(label, HPos.CENTER);
            }
            else {
                gridPane.add(new Label(),0,i);

            }

            for(int j=1; j<mapWidth;j++)
            {
                 object = map.objectsAt(new Vector2d(j,i));
                if (object != null)
                {

                    Label label = new Label("");
                    label.setGraphic(object.getToDisplay().getImage());
                    gridPane.add(label,j,i );
                    GridPane.setHalignment(label, HPos.CENTER);

                }
                else{
                    gridPane.add(new Label(),j,i );
                }




            }
        }


        gridPane.setAlignment(Pos.CENTER);
        return gridPane;


    }

    private void setSizeOfSingleCell(int mapWidth, int mapHeight,int size)
    {

        for(int i=0; i < mapWidth;i++)
        {
            ColumnConstraints column = new ColumnConstraints(size);
            gridPane.getColumnConstraints().add(column);
        }

        for(int i=0; i < mapHeight;i++)
        {
            RowConstraints row = new RowConstraints(size);
            gridPane.getRowConstraints().add(row);
        }

    }



}
