import java.util.Random;

public class Obstacle {
    private int numberOfObs,obsDmg,obsHlt,obsMny;
    private String name;

    Random rand = new Random();

    public Obstacle(String name,int obsDmg , int obsHlt,int obsMny ) {
        this.name = name;
        this.obsDmg = obsDmg;
        this.obsHlt = obsHlt;
        this.obsMny = obsMny;
        this.numberOfObs = ObstacleNumber();
    }

    public int   ObstacleNumber(){
        numberOfObs = rand.nextInt(2)+1;
        return numberOfObs;
    }

    //GETTER
    public int getNumberOfObs() {
        return numberOfObs;
    }

    public int getObsDmg() {
        return obsDmg;
    }

    public int getObsHlt() {
        return obsHlt;
    }

    public int getObsMny() {
        return obsMny;
    }

    public String getName() {
        return name;
    }

    //SETTER
    public void setNumberOfObs(int numberOfObs) {
        this.numberOfObs = numberOfObs;
    }

    public void setObsDmg(int obsDmg) {
        this.obsDmg = obsDmg;
    }

    public void setObsHlt(int obsHlt) {
        this.obsHlt = obsHlt;
    }

    public void setObsMny(int obsMny) {
        this.obsMny = obsMny;
    }

    public void setName(String name) {
        this.name = name;
    }
}