package Core;

import AnimalData.Energy;
import AnimalData.Genome;

import Gui.App;
import Map.IWorldMap;
import Map.PortalMap;
import Objects.Animal;
import Simulation.SimulationEngine;
import animalmanagement.Creator;
import animalmanagement.DeathSpecter;
import animalmanagement.Interaction;
import animalmanagement.Rank;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {

        //uruchamianie klasy App

         Config config = new Config(1,90,6,60,3,1);
         IWorldMap map = new PortalMap(10,10,18,3,config);
         SimulationEngine engine = new SimulationEngine(config,map);
         engine.run();


        Application.launch(App.class, args);







    }

}
