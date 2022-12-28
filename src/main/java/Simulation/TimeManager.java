package Simulation;

import java.util.ArrayList;

public class TimeManager {


    private ArrayList<IDayChangeAction> actions = new ArrayList<IDayChangeAction>();

    private int passedDay = 0;

    public void changeDay()
    {
        for(IDayChangeAction action : actions)
        {
            action.OnPassingDay();
        }
        this.passedDay+=1;



    }










}
