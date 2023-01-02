package Gui;

import Core.Config;
import Map.IWorldMap;
import Map.PortalMap;
import Map.RoundMap;
import Simulation.SimulationEngine;
import Simulation.SimulationListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;


public class App implements SimulationListener {


    private IWorldMap map;
    private SimulationVisualizer visualizer;
    private Stage primaryStage;
    private GridPane gridPane;
    private final  int SCREEN_WIDTH = 1200;
    private final int SCREEN_HEIGHT = 900;

    private int energyReqToCreateAnimal;
    private int startEnergy;
    //DODAJ POLACZENIE Z MENU
    public App(Stage primaryStage,Config configgg) {
        Config config = new Config(1000,400,50,400,10,25);
        IWorldMap map = new RoundMap(15,15,20,3,config);
        this.map = map;
        SimulationEngine engine = new SimulationEngine(config,map,this);
        engine.addSimulationObservers(this);
        Thread engineThread = new Thread(engine);
        engineThread.start();
        visualizer = new SimulationVisualizer(map,SCREEN_WIDTH/map.getWidth(), SCREEN_HEIGHT/map.getHeight());
        gridPane = visualizer.setMap();
        this.primaryStage = primaryStage;
    }


    public void start() throws Exception {
        visualizer.setMap();

        Scene scene = new Scene(gridPane,SCREEN_WIDTH,SCREEN_HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double windowWidth = primaryStage.getWidth();
        double windowHeight = primaryStage.getHeight();
        primaryStage.setX((screenWidth - windowWidth) / 2);
        primaryStage.setY((screenHeight - windowHeight) / 2);





    }
    public void updateMap()
    {
        Platform.runLater(() -> {


            gridPane = visualizer.setMap();

        });



    }



    //Kontroluje wszystkie przyciski, wyświetlanie - odświeżanie dnia, włączanie symulacji itd.

}
