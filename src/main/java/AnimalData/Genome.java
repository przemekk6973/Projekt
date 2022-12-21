

package AnimalData;
import Objects.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class Genome {

    private final int numOfGenes;
    //tablica z ruchami
    private int[] behaviour;
    //wskaznik do obecnej pozycji
    private int pointerToCurrentGen = 0;

    //generuje nowe zwierzęta
    public Genome(int numOfGenes)
    {
         this.numOfGenes = numOfGenes;
         this.behaviour = new Random()
                .ints(numOfGenes, 0, 7)
                .toArray();

    }

    //tworze nowy genom z rodzicow (zwierze 1, zwierze 2, dlugosc genomu)
    public Genome(Animal parent1, Animal parent2,int numOfGenes) {
        this.numOfGenes = numOfGenes;
        this.behaviour = new int[numOfGenes];
        Random random = new Random();
        int sumOfEnergy = parent1.getEnergy() + parent2.getEnergy();
        double proportionParent1 =  (double) parent1.getEnergy() / sumOfEnergy;
        proportionParent1 *=100;
        int sideToStart = random.nextInt(2);

        int[] pointers = cutGenome(sideToStart,Math.max((int) Math.round(proportionParent1),100- (int)Math.round(proportionParent1)));

        Animal geneDonor = (proportionParent1 >= 50) ? parent1 : parent2;
        for(int i=pointers[0];i<pointers[1];i++)
            behaviour[i] = geneDonor.getGenome().getBehaviour()[i];

        pointers = (pointers[0] == 0) ? new int[]{pointers[1],numOfGenes} : new int[]{0,pointers[0]};

        geneDonor = (proportionParent1 < 50) ? parent1 : parent2;
        for(int i=pointers[0];i<pointers[1];i++)
            behaviour[i] = geneDonor.getGenome().getBehaviour()[i];
        mutation();

    }

    private int[]cutGenome(int sideToStart,int proportion)
    {
        return switch (sideToStart) {
            case 0 -> new int[]{0,(int) Math.round((numOfGenes * ((double)proportion/100)))};
            case 1 -> new int[]{numOfGenes - (int) Math.round((numOfGenes * ((double)proportion/100))) , numOfGenes};
            default -> throw new IllegalStateException("Unexpected value: " + sideToStart);
        };

    }

    private void mutation()
    {
        Random random = new Random();
        int numOfGensToMutate = random.nextInt(numOfGenes);
        for (int i =0; i< numOfGensToMutate; i++)
        {
            int takeGen = random.nextInt(numOfGenes);
            int addOrSubtract = random.nextInt(2);
           behaviour[takeGen]  = switch (addOrSubtract)
            {
                case 0 -> (takeGen +1 < 8)? takeGen+1 : 0;
                case 1 -> (takeGen - 1 >=0)? takeGen-1 : 8;
                default -> throw new IllegalStateException("Unexpected value: " + addOrSubtract);
            };

        }

    }
    public int []getBehaviour() {
        return behaviour;
    }

    //w 80% przypadkow biore nastepny gen w 20% losuje nowy
    public void changePointer()
    {
        Random random = new Random();
        int n = random.nextInt(10);
        if (n < 8)
            pointerToCurrentGen = (pointerToCurrentGen + 1 < numOfGenes) ? pointerToCurrentGen + 1 : 0;
        else
        {
            ArrayList<Integer> possibleBehaviour = new ArrayList<>();
            Arrays.stream(behaviour).filter(x -> x != pointerToCurrentGen).forEach(possibleBehaviour::add);
            Collections.shuffle(possibleBehaviour);
            pointerToCurrentGen = possibleBehaviour.get(0);
        }

    }





}
