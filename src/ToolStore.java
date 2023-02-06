import java.util.Scanner;

public class ToolStore extends SafeLocations{

    Scanner scan = new Scanner(System.in);
    private int secim;

    public ToolStore(Player player, Inventory inv) {
        super(player, inv,"Market");

    }

    @Override
    public boolean getLocation() {
        printStore();
        return true;
    }

    public void printStore(){
        System.out.println("MEVCUT PARANIZ-->"+player.getMoney()+"\n\n");
        System.out.println("1-Tabanca     Bonus Hasar: 2     Ücret: 25");
        System.out.println("2-Kılıç       Bonus Hasar: 3     Ücret: 35");
        System.out.println("3-Tüfek       Bonus Hasar: 7     Ücret: 45");

        System.out.println("--------------------------------------------");

        System.out.println("4-Hafif Zırh       Azaltacağı Hasar: 1     Ücret: 15");
        System.out.println("5-Yarım Zırh       Azaltacağı Hasar: 3     Ücret: 25");
        System.out.println("6-Ağır  Zırh       Azaltacağı Hasar: 5     Ücret: 40");

        System.out.println("0-Herhangi bir şey almak istemiyorum");
        System.out.print("Seçiminiz--> ");
        secim = scan.nextInt();

        if(secim<0 || secim>6){
            System.out.println("Lütfen geçerli bir işlem seçiniz!!");
            secim = scan.nextInt();
        }
        if(secim==1){
            if(player.getMoney()>25){
                inv.boostWeapon=2;
                System.out.println("Tabanca envanterinize eklendi!");
                player.setMoney(player.getMoney()-25);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

        if(secim==2){
            if(player.getMoney()>35){
                inv.boostWeapon=3;
                System.out.println("Kılıç envanterinize eklendi!");
                player.setMoney(player.getMoney()-35);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

        if(secim==3){
            if(player.getMoney()>45){
                inv.boostWeapon=7;
                System.out.println("Tüfek envanterinize eklendi!");
                player.setMoney(player.getMoney()-45);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

        if(secim==4){
            if(player.getMoney()>15){
                inv.boostArmour=1;
                System.out.println("Hafif zırh envanterinize eklendi!");
                player.setMoney(player.getMoney()-15);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

        if(secim==5){
            if(player.getMoney()>25){
                inv.boostArmour=3;
                System.out.println("Yarım zırh envanterinize eklendi!");
                player.setMoney(player.getMoney()-25);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

        if(secim==6){
            if(player.getMoney()>40){
                inv.boostArmour=5;
                System.out.println("Ağır zırh envanterinize eklendi!");
                player.setMoney(player.getMoney()-40);
                System.out.println("Mevcut paranız--> "+player.getMoney());
            }
            else
                System.out.println("Üzgünüm. Yeteri kadar paranız yok");
        }

    }

}
