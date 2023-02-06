public class Inventory {

    private int weaponId=0,armourId=0;
    public int boostWeapon=0,boostArmour=0;
    private boolean yemek=false,su=false,odun=false;

    public void chngWeapon(){
        switch(getWeaponId()){
            case 1:
                boostWeapon = 2;
                break;
            case 2:
                boostWeapon = 3;
                break;
            case 3:
                boostWeapon = 7;
                break;

            default:
                boostWeapon=0;
                break;
        }
    }

    public void chngArmour(){
        switch(getArmourId()){
            case 1:
                boostArmour = 1;
                break;
            case 2:
                boostArmour = 3;
                break;
            case 3:
                boostArmour = 5;
                break;

            default:
                boostArmour=0;
                break;
        }
    }




    //GETTER
    public int getWeaponId() {
        return weaponId;
    }

    public int getArmourId() {
        return armourId;
    }

    public boolean isYemek() {
        return yemek;
    }

    public boolean isSu() {
        return su;
    }

    public boolean isOdun() {
        return odun;
    }


    //SETTER
    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public void setArmourId(int armourId) {
        this.armourId = armourId;
    }

    public void setFood(boolean yemek) {
        this.yemek = yemek;
    }

    public void setWater(boolean su) {
        this.su = su;
    }

    public void setFirewood(boolean odun) {
        this.odun = odun;
    }
}
