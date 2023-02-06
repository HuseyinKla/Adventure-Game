public abstract class SafeLocations extends Location{


    public SafeLocations(Player player, Inventory inv,String name) {
        super(player, inv);
        this.name = name;
    }


    @Override
    public abstract boolean getLocation();

}
