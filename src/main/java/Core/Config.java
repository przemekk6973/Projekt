package Core;

public class Config {


    private int energyReqToCreateAnimal;

    private int numOfGenens;

    private int startEnergy;


    public Config(int energyReqToCreateAnimal,int numOfGenens)
    {
        this.energyReqToCreateAnimal = energyReqToCreateAnimal;
        this.numOfGenens = numOfGenens;


    }

    public int getEnergyReqToCreateAnimal() {
        return energyReqToCreateAnimal;
    }

    public int getNumOfGenens() {
        return numOfGenens;
    }

    public int getStartEnergy() {
        return startEnergy;
    }
}
