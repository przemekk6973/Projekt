package Objects;

import AnimalData.Energy;
import AnimalData.Genome;
import Core.Config;
import Core.IPositionChangeObserver;
import Core.Vector2d;
import Gui.GuiElementBox;
import Map.IWorldMap;
import Map.MapDirection;
import Map.MoveDirection;

import java.util.ArrayList;

public class Animal {

    private Genome genome;
    private Energy energy;


    private MapDirection orientation = MapDirection.NORTH;

    private GuiElementBox toDisplay;

    private Vector2d position;

    private IWorldMap map;



    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    //zwierze wygenerowane
    public Animal(Genome genome,Energy energy)
    {
        this.genome = genome;
        this.energy = energy;
        setRandomPosition();


    }
    //zwierzak powstały
    public Animal(Genome genome,Energy energy, Vector2d position)
    {
        this.genome = genome;
        this.energy = energy;
        this.position = position;

    }

    public int getEnergy() {
        return energy.getEnergy();
    }

    public Genome getGenome() {
        return genome;
    }

    private void setRandomPosition()
    {
        //losowa pozycja i kierunek

    }

    public void move(MoveDirection direction)
    {
        Vector2d newPosition = new Vector2d(position.x, position.y);
        switch(direction)
        {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FOWARD -> newPosition = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.orientation.toUnitVector());

        }
        //jeszcze mapa nie zaimplementowana
//        if (map.canMoveTo(newPosition)) {
//            positionChanged(position,new Vector2d(newPosition.x, newPosition.y));
//            this.position = new Vector2d(newPosition.x, newPosition.y);
//        }



    }
    public void setAnimalEnergy(int newEnergy) {
        energy.setEnergy(newEnergy);
    }

    public void addObserver(IPositionChangeObserver observer){observers.add(observer);}
    private void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    public MapDirection getOrientation() {
        return orientation;
    }
    public Vector2d getPosition() { return position; }



}
