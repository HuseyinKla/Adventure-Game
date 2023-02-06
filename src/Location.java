public abstract class Location{
    protected Player player;
    protected Inventory inv;
    protected String name;


    Location(Player player,Inventory inv){
        this.player = player;
        this.inv = inv;
    }

public abstract boolean getLocation();



    //GETTER
    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    //SETTER
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

}
