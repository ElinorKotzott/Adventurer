public class BossFight {
    private int health;
    private int damage;
    private boolean isBossCharging;
    private String name;

    public BossFight(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }




    public boolean takeDamage(Dungeon dungeon, Hero hero) {
        health = health - hero.attack();
        if (health <= 0) {
            System.out.println("Congrats, you defeated " + this.name + "!");
            dungeon.removeName(this.name, hero);
            return true;
        }
        System.out.println("Current boss hp: " + health);
        return false;
    }

    public int attack() {
        if (!isBossCharging) {
            if (Math.random() <= 0.5) {
                return (int) (Math.random() * damage);
            }
            isBossCharging = true;
            System.out.println("The boss is preparing to do extra damage with a charged attack!");
            return 0;
        }
        isBossCharging = false;
        return (int) (Math.random() * damage) * 10;
    }



    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }


}
