//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your hero's name. Be mindful as you cannot change the name later in the game.");

        Hero hero1 = new Hero(scanner.nextLine(), 1000);

        AsciiArt asciiArt = new AsciiArt();

        asciiArt.drawString(hero1.getName(), "^");

        Dungeon dungeon1 = new Dungeon(7, 7);
        Logic logic = new Logic();


        for (; ; ) {
            if (dungeon1.move()) {
                if (dungeon1.isBossRoom() || Math.random() <= 0.5) {
                    logic.bossFight(hero1, dungeon1.getUniqueVisitedRoomsCounter(), scanner, dungeon1);
                } else {
                    logic.lootRoom(hero1, dungeon1.getUniqueVisitedRoomsCounter(), scanner, false);
                }
            }
        }

    }


}