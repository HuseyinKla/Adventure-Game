public class SafeHouse extends SafeLocations{


    public SafeHouse(Player player, Inventory inv) {
        super(player, inv,"Güvenli ev");
    }

    @Override
    public boolean getLocation(){
        System.out.println("Canınız doluyor...");
        player.setRealHealty(player.getHealty());
        return true;
    }


}
