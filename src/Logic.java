import java.util.Scanner;

public class Logic {

    public void bossFight(Hero hero, int uniqueVisitedRoomsCounter, Scanner scanner, Dungeon dungeon) {
        dungeon.markBossRoom();
        BossFight bossFight = new BossFight(1000, 100, dungeon.getBossName());
        System.out.println("Boss room: you found " + bossFight.getName() + " with " + bossFight.getHealth() + "HP and " + bossFight.getDamage() + " ATT. What do you want to do?");
        while (true) {
            System.out.println("Write 'a' to attack, 'd' to defend or 'r' to run");
            String input = scanner.nextLine();
            if ("a".equalsIgnoreCase(input)) {
                if (bossFight.takeDamage(dungeon, hero)) {
                    lootRoom(hero, uniqueVisitedRoomsCounter, scanner, true);
                    return;
                } else {
                    hero.takeDamage(bossFight.attack());
                }

            } else if ("d".equalsIgnoreCase(input)) {
                hero.defend();
                hero.takeDamage(bossFight.attack());

            } else if ("r".equalsIgnoreCase(input)) {
                dungeon.markNotVisited();
                System.out.println("This boss looked scary! You made it out alive.");
                return;
            }
        }
    }

    public void lootRoom(Hero hero, int uniqueVisitedRoomsCounter, Scanner scanner, boolean isBossRoom) {
        if (!isBossRoom) {
            System.out.println("You can loot this room");
        } else {
            System.out.println("The boss drops an extra strong item!");
        }

        int lootGenerator = (int) (Math.random() * 6);
        int lootStat = uniqueVisitedRoomsCounter + (int) (Math.random() * 101);
        if (isBossRoom) {
            lootStat = lootStat + 50;
        }
        switch (lootGenerator) {
            case 0:
                System.out.println(hero.getName() + ", you found a helmet with a defense value of " + lootStat);
                break;
            case 1:
                System.out.println(hero.getName() + ", you found a plated armor with a defense value of " + lootStat);
                break;
            case 2:
                System.out.println(hero.getName() + ", you found gloves with a defense value of " + lootStat);
                break;
            case 3:
                System.out.println(hero.getName() + ", you found leg plates with a defense value of " + lootStat);
                break;
            case 4:
                System.out.println(hero.getName() + ", you found boots with a defense value of " + lootStat);
                break;
            case 5:
                System.out.println(hero.getName() + ", you found a sword with an attack value of " + lootStat + ". Do you want to equip it for your right hand? Write 'right'. Do you want to equip it for your left hand? Write 'left'.");
                System.out.println("Don't want to equip it? Write 'no'. These are your current stats: ");
                System.out.println("Left sword: " + hero.getLeftHandSword());
                System.out.println("Right sword: " + hero.getRightHandSword());

                while (true) {
                    String input = scanner.nextLine();
                    if ("right".equalsIgnoreCase(input)) {
                        hero.setRightHandSword(lootStat);
                        return;
                    } else if ("left".equalsIgnoreCase(input)) {
                        hero.setLeftHandSword(lootStat);
                        return;
                    } else if ("no".equalsIgnoreCase(input)) {
                        return;
                    }
                    System.out.println("Write 'right', 'left' or 'no'!");
                }
            default:
                return;
        }

        System.out.println("Do you want to equip the new item? These are your current stats: ");
        System.out.println("Helmet: " + hero.getHelmet());
        System.out.println("Plated armor: " + hero.getPlatedArmor());
        System.out.println("Gloves: " + hero.getGloves());
        System.out.println("Leg plates: " + hero.getLegPlate());
        System.out.println("Boots: " + hero.getBoots());

        while (true) {
            System.out.println("Write yes or no!");
            String input = scanner.nextLine();
            if ("yes".equalsIgnoreCase(input)) {
                switch (lootGenerator) {
                    case 0:
                        hero.setHelmet(lootStat);
                        break;
                    case 1:
                        hero.setPlatedArmor(lootStat);
                        break;
                    case 2:
                        hero.setGloves(lootStat);
                        break;
                    case 3:
                        hero.setLegPlate(lootStat);
                        break;
                    case 4:
                        hero.setBoots(lootStat);
                        break;
                    default:
                        return;
                }
                return;
            } else if ("no".equalsIgnoreCase(input)) {
                return;
            }
        }


    }


}
