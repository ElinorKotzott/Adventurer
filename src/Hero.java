public class Hero {

    private String name;
    private int helmet;
    private int platedArmor;
    private int gloves;
    private int legPlate;
    private int boots;
    private int health;
    private int leftHandSword;
    private int rightHandSword;
    private boolean isDefending;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int bossDamage) {
        if (!isDefending) {
            if (bossDamage <= getArmor()/10) {
                System.out.println("Your current hp: " + health);
                return;
            }
            health = health - bossDamage + (int) (getArmor()/10);
        } else {
            health = (int) (health - bossDamage * 0.1);
            isDefending = false;
        }
        if (health <= 0) {
            System.out.println("You died. Game over!");
            System.exit(0);
        }
        System.out.println("Your current hp: " + health);
    }

    private int getArmor () {
        return helmet + platedArmor + gloves + legPlate + boots;
    }

    public void defend() {
        isDefending = true;
    }

    public int attack() {
        return (int) (Math.random() * 101) + leftHandSword + rightHandSword;
    }

    public String getName() {
        return name;
    }

    public int getHelmet() {
        return helmet;
    }

    public void setHelmet(int helmet) {
        this.helmet = helmet;
    }

    public int getPlatedArmor() {
        return platedArmor;
    }

    public void setPlatedArmor(int platedArmor) {
        this.platedArmor = platedArmor;
    }

    public int getGloves() {
        return gloves;
    }

    public void setGloves(int gloves) {
        this.gloves = gloves;
    }

    public int getLegPlate() {
        return legPlate;
    }

    public void setLegPlate(int legPlate) {
        this.legPlate = legPlate;
    }

    public int getBoots() {
        return boots;
    }

    public void setBoots(int boots) {
        this.boots = boots;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLeftHandSword() {
        return leftHandSword;
    }

    public void setLeftHandSword(int leftHandSword) {
        this.leftHandSword = leftHandSword;
    }

    public int getRightHandSword() {
        return rightHandSword;
    }

    public void setRightHandSword(int rightHandSword) {
        this.rightHandSword = rightHandSword;
    }

}
