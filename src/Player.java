import java.util.Scanner;

public class Player {
    private  Inventory inv;
    private int damage,healty,money,secim;
    private String pName,cName;

    private int realDamage,realHealty,realMoney;


    Scanner scan = new Scanner(System.in);

    Player(String pname, Inventory inv){
        this.pName = pname;
        this.inv = inv;
    }

    public void selectCha(){
        switch(chaMenu()){
            case 1:
                creatCha(5,21,15,"Samuray");
                break;
            case 2:
                creatCha(7,18,20,"Okçu");
                break;
            case 3:
                creatCha(8,24,5,"Şovalye");
                break;
        }
        printCha();
    }

    public int chaMenu(){
        System.out.println("LÜTFEN OYNAMAK İSTEDİĞİNİZ KARAKTERİ SEÇİNİZ: ");
        System.out.println("1-Samuray   Hasar: 5     Sağlık: 21     Para: 15");
        System.out.println("2-Okçu      Hasar: 7     Sağlık: 18     Para: 20");
        System.out.println("3-Şovalye   Hasar: 8     Sağlık: 24     Para: 5");
        secim = scan.nextInt();

        if(secim<1 || secim>3){
            System.out.println("1 ve 3 arasından bir karakter seçiniz!!");
            secim = scan.nextInt();
        }

        return secim;
    }

    public void creatCha(int dmg, int hlt, int mny,String cname){
        setDamage(dmg);
        setHealty(hlt);
        setMoney(mny);
        setcName(cname);
        setRealHealty(hlt);
        setRealDamage(dmg);
    }


    public void printCha(){
        System.out.println("Karakterinizin türü--> "+getcName());
        System.out.println("Karakterinizin hasarı--> "+getDamage());
        System.out.println("Karakterinizin canı--> "+getHealty());
        System.out.println("Karakterinizin parası--> "+getMoney());
    }

    public void currentAbilities(){
        System.out.println("\n\n\nKarakterinizin ana hasarı--> "+getDamage());
        System.out.println("Karakterinizin bonus hasarı--> "+(inv.boostWeapon));
        System.out.println("Karakterinizin mevcut hasarı--> "+(getDamage()+inv.boostWeapon));
        System.out.println("Karakterinizin canı--> "+(getHealty()));
        System.out.println("Düşmanlardan azaltılacak hasar--> "+(inv.boostArmour));
        System.out.println("Karakterinizin parası--> "+getMoney());
    }




    //GETTER
    public int getDamage() {
        return damage;
    }

    public int getHealty() {
        return healty;
    }

    public int getMoney() {
        return money;
    }

    public String getpName() {
        return pName;
    }

    public String getcName() {
        return cName;
    }


    public int getRealDamage() {
        return realDamage;
    }

    public int getRealHealty() {
        return realHealty;
    }

    public int getRealMoney() {
        return realMoney;
    }

    //SETTER
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }


    public void setRealDamage(int realDamage) {
        this.realDamage = realDamage;
    }

    public void setRealHealty(int realHealty) {
        this.realHealty = realHealty;
    }

    public void setRealMoney(int realMoney) {
        this.realMoney = realMoney;
    }
}