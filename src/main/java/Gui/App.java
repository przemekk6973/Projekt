package Gui;

import Core.Config;
import Core.Vector2d;
import Map.IWorldMap;
import Map.PortalMap;
import Objects.IMapElement;
import Simulation.SimulationEngine;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.awt.*;
import java.util.List;

public class App extends Application {


    private IWorldMap map;
    private SimulationVisualizer visualizer;

    private GridPane gridPane;
    public void init() throws Exception {
        Config config = new Config(1,10,12,20,20,6);
        IWorldMap map = new PortalMap(20,20,60,3,config);
        this.map = map;
        SimulationEngine engine = new SimulationEngine(config,map,this);

        Thread engineThread = new Thread(engine);
        engineThread.start();
        visualizer = new SimulationVisualizer(map);
        gridPane = visualizer.showMap();






    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        visualizer.showMap();
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();






    }
    public void updateMap()
    {
        Platform.runLater(() -> {


            gridPane = visualizer.showMap();

        });



    }



    //Kontroluje wszystkie przyciski, wyświetlanie - odświeżanie dnia, włączanie symulacji itd.

}
