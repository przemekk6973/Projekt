package Gui;

import Core.Config;
import Map.IWorldMap;
import Map.PortalMap;
import Simulation.SimulationEngine;
import Simulation.SimulationListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application implements SimulationListener {


    private IWorldMap map;
    private SimulationVisualizer visualizer;

    private GridPane gridPane;
    public void init() throws Exception {
        //najpierw trawe
        Config config = new Config(3000,500,50,450,4,20);
        IWorldMap map = new PortalMap(15,15,80,3,config);
        this.map = map;
        SimulationEngine engine = new SimulationEngine(config,map,this);
        engine.addSimulationObservers(this);


        Thread engineThread = new Thread(engine);
        engineThread.start();


        visualizer = new SimulationVisualizer(map);
        gridPane = visualizer.setMap();






    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        visualizer.setMap();
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();






    }
    public void updateMap()
    {
        Platform.runLater(() -> {


            gridPane = visualizer.setMap();

        });



    }



    //Kontroluje wszystkie przyciski, wyświetlanie - odświeżanie dnia, włączanie symulacji itd.

}
