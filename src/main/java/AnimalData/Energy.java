package AnimalData;
import java.util.Random;
public class Energy {

    private int energy;

    public int getEnergy() {
        return energy;
    }


    public Energy()
    {
        Random random = new Random();
        this.energy = random.nextInt(40)+1;

    }



}
