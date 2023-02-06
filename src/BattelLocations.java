import java.util.Scanner;

public abstract class BattelLocations extends Location{

    protected Obstacle obstacle;
    private int secim,count;
    protected String award;


    Scanner scan = new Scanner(System.in);

    BattelLocations(Player player, Inventory inv,String name,Obstacle obstacle,String award) {
        super(player, inv);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }


    public  int battelLoc(){
        return 1;
    }

    public void combat() {

    }

    public boolean getLocation(){
    count = obstacle.getNumberOfObs();
    System.out.println("Şuan bu konumdasınız: "+this.getName());
    System.out.println("Önünüze "+count+" tane "+obstacle.getName()+" çıktı!!");
    System.out.println("Düşmana saldırmak için 1 Düşmandan kaçmak için 0 basınız. Kaçarken hasar alacağınızı unutmayınız!!");



        System.out.print("1-> Savaş          2->Kaç\n\nSeçiminiz--> ");
        secim=scan.nextInt();


        if(secim==1){
            if(combat(count)){
                System.out.println("\n\nTüm düşmanları öldürdünüz");
                if(this.award.equals("Yemek") && !inv.isYemek()){
                    System.out.println(this.award+" KAZANDINIZ");
                    inv.setFood(true);
                }
                else if(this.award.equals("Su") && !inv.isSu()){
                    System.out.println(this.award+" KAZANDINIZ");
                    inv.setWater(true);
                }
                else if(this.award.equals("Odun") && !inv.isOdun()){
                    System.out.println(this.award+" KAZANDINIZ");
                    inv.setFirewood(true);
                }
                return true;
            }
            else{
                System.out.println("Öldünüz...");
                return false;

            }
        }
        else if(secim==2){
            obsHit();
            afterHit();
        }
        return true;
        }



    public boolean combat(int count){
            for(int i=0 ; i<count ; i++) {
                int obsHealth = obstacle.getObsHlt();
                playerInfo();
                obsInfo();
                while(player.getRealHealty()>0 && obstacle.getObsHlt()>0){

                    System.out.print("\n1-> Savaş          2->Kaç\n\nSeçiminiz--> ");
                    secim=scan.nextInt();
                    if(secim==1){
                        playerHit();
                        afterHit();
                        if(obstacle.getObsHlt()>0){
                            obsHit();
                            afterHit();
                        }
                    }
                    else if(secim==2){
                        obsHit();
                        afterHit();
                        break;
                    }
                    else
                        System.out.println("Lütfen geçerli bir sayı giriniz!!");
                }

                if(obstacle.getObsHlt() <=0 && player.getRealHealty()>0){
                    System.out.println("\n"+(i+1)+". "+obstacle.getName()+" yendiniz");
                    player.setMoney(player.getMoney() + obstacle.getObsMny());
                    System.out.println("\nGüncel paranız--> "+player.getMoney());
                    obstacle.setObsHlt(obsHealth);
                }
                else if(player.getRealHealty()>0)
                    return true;
                else
                    return false;
            }
            return true;
        }



    public void playerInfo(){
        System.out.println("OYUNCU DEĞERLERİ\n");
        System.out.println("Karakterinizi canı--> "+player.getRealHealty());
        System.out.println("Karakterinizi toplam hasarı--> "+(player.getDamage()+inv.boostWeapon));
        System.out.println("Karakterinizi parası--> "+player.getMoney());
    }

    public void obsInfo(){
        System.out.println("\n"+obstacle.getName()+" DEĞERLERİ");
        System.out.println("Canı--> "+obstacle.getObsHlt());
        System.out.println("Hasarı--> "+obstacle.getObsDmg());
        System.out.println("Kazanacağınız ödül--> "+obstacle.getObsMny());
    }

    public void afterHit(){
        System.out.println("Oyuncu canı--> "+player.getRealHealty());
        System.out.println(obstacle.getName()+" Canı-->"+obstacle.getObsHlt());
    }

    public void playerHit(){
        System.out.println("Siz vurdunuz");
        obstacle.setObsHlt(obstacle.getObsHlt()-(player.getRealDamage()+inv.boostWeapon));
    }

    public void obsHit(){
        System.out.println("\n"+obstacle.getName()+" size vurdu");

        if((inv.boostArmour - obstacle.getObsDmg()) >=0 ){
            System.out.println("AMA HASAR ENGELLENDİ. ZIRH SAYESİNDE HASAR ALMADINIZ");
            return;
        }
        player.setRealHealty(player.getRealHealty() - obstacle.getObsDmg() + inv.boostArmour);
    }

}
