package Objects;

import AnimalData.Energy;
import AnimalData.Genome;

public class Animal {

   private Genome genome;
   private Energy energy;

    public Animal(Genome genome,Energy energy)
    {
        this.genome = genome;
        this.energy = energy;

    }
    public int getEnergy() {
        return energy.getEnergy();
    }

    public Genome getGenome() {
        return genome;
    }
}
