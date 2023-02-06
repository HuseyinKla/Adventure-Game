import java.util.Scanner;

public class Game {

    public Player player;
    public Location loc;
    public Inventory inv = new Inventory();
    private int secim;
    public boolean ctrl = false;

    Scanner scan = new Scanner(System.in);


    public void login() {
        System.out.println("MACERA OYUNUNA HOŞGELDİNİZ");
        System.out.println("\n-------------------------------------------------------\n");
        System.out.println("\nOYUNDAKİ İSMİNİZİ BELİRLEYİNİZ: ");
        String playerName = scan.nextLine();
        player = new Player(playerName, inv);
        player.selectCha();

        start();
    }


    public void start() {


        while (true) {

            System.out.println("\n1-Güvenli Ev -->  Canınınz dolar");
            System.out.println("2-Mağaza --> Eşya satın alabilirsiniz\n");
            System.out.println("3-Orman --> Vampir çıkabilir(1-3) Kazanacağınız eşya --> Yemek");
            System.out.println("4-Nehir --> Ayı çıkabilir(1-3)    Kazanacağınız eşya --> Odun");
            System.out.println("5-Mağara --> Zombi çıkabilir(1-3) Kazanacağınız eşya --> Su");
            System.out.println("6-Tüm yaratıkların özelliklerini öğrenmek istiyorum");
            System.out.println("7-Mevcut Tüm özelliklerimi öğrenmek istiyorum");


            System.out.print("\nGitmek istediğiniz bölgeyi seçiniz: ");
            secim = scan.nextInt();

            switch(secim){
                case 1:
                    if(inv.isOdun() && inv.isSu() && inv.isYemek()){
                        System.out.println("\n\nTEBRİKLER OYUNU KAZANDINIZ");
                        ctrl = true;
                        break;
                    }
                    loc = new SafeHouse(player,inv);
                    break;
                case 2:
                    loc = new ToolStore(player,inv);
                    break;

                case 3:
                    loc = new Forest(player,inv);
                    break;

                case 4:
                    loc = new River(player,inv);
                    break;

                case 5:
                    loc = new Cave(player,inv);
                    break;

                case 6:
                    printEnemy();
                    break;

                case 7:
                    player.currentAbilities();
                    break;

                default:
                    loc = new SafeHouse(player,inv);
                    break;
            }


            /*if (secim == 1)
                loc = new SafeHouse(player, inv);

            if (secim == 2)
                loc = new ToolStore(player, inv);

            if (secim == 3)
                loc = new Forest(player, inv);

            if (secim == 4)
                loc = new River(player, inv);

            if (secim == 5)
                loc = new Cave(player, inv);

            if (secim == 6)
                printEnemy();
            if (secim == 7)
                player.currentAbilities();*/

            if (ctrl)
                return;

            if (!loc.getLocation()) {
                System.out.println("yenildiniz");
                return;
            }

        }
    }




    public void printEnemy(){
        System.out.println("VAMPİR      Verdiği Hasar: 4       Sağlık: 14       Kazanacağınız para: 7");
        System.out.println("ZOMBİ       Verdiği Hasar: 3       Sağlık: 10       Kazanacağınız para: 4");
        System.out.println("AYI         Verdiği Hasar: 7       Sağlık: 20       Kazanacağınız para: 12");
    }
}