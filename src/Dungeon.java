import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private ArrayList<String> bossNames = MyFileReader.loadBossNames();

    private int uniqueVisitedRoomsCounter;

    Scanner scanner = new Scanner(System.in);
    private int x;
    private int y;

    private int maxWidth;
    private int maxHeight;


    DungeonRoom[][] map;


    public Dungeon(int width, int height) {

        this.maxWidth = width;
        this.maxHeight = height;


        map = new DungeonRoom[width][height];


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = new DungeonRoom();
            }
        }

        map[x][y].setVisited(true);
    }

    public boolean move() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        for (; ; ) {
            System.out.println("Enter wasd");
            String inputLetter = scanner.nextLine();
            if ("w".equalsIgnoreCase(inputLetter)) {
                if (y != 0) {
                    y = y - 1;
                    if (isVisited()) {
                        return true;
                    }
                    break;
                }
                invalidMoveMessage();
            } else if ("s".equalsIgnoreCase(inputLetter)) {
                if (y < maxHeight - 1) {
                    y = y + 1;
                    if (isVisited()) {
                        return true;
                    }
                    break;
                }
                invalidMoveMessage();
            } else if ("a".equalsIgnoreCase(inputLetter)) {
                if (x != 0) {
                    x = x - 1;
                    if (isVisited()) {
                        return true;
                    }
                    break;
                }
                invalidMoveMessage();
            } else if ("d".equalsIgnoreCase(inputLetter)) {
                if (x < maxWidth - 1) {
                    x = x + 1;
                    if (isVisited()) {
                        return true;
                    }
                    break;
                }
                invalidMoveMessage();
            }

        }
        System.out.println("You're in a room that you have already been in: " + "[" + x + "]" + "[" + y + "]");
        return false;
    }

    private boolean isVisited() {
        if (!map[x][y].isVisited()) {
            map[x][y].setVisited(true);
            uniqueVisitedRoomsCounter = uniqueVisitedRoomsCounter + 1;
            System.out.println("You're in room " + "[" + x + "]" + "[" + y + "]");
            return true;
        }
        return false;
    }

    public void markBossRoom() {
        map[x][y].setBossRoom(true);
    }

    public void markNotVisited() {
        map[x][y].setVisited(false);
        uniqueVisitedRoomsCounter = uniqueVisitedRoomsCounter - 1;
    }

    private void invalidMoveMessage() {
        System.out.println("You cannot move into that direction!");
    }

    public int getUniqueVisitedRoomsCounter() {
        return uniqueVisitedRoomsCounter;
    }

    public String getBossName() {
        return bossNames.get((int) (Math.random() * bossNames.size()));

    }

    public void removeName(String name, Hero hero) {
        bossNames.remove(name);
        if (bossNames.isEmpty()) {
            System.out.println("CONGRATULATIONS, " + hero.getName() + ", you killed 100 bosses and finished the game!");
            System.exit(0);
        }
    }

    public boolean isBossRoom() {
        return map[x][y].isBossRoom();
    }


    // visited boss rooms have to contain same bosses again
    // achievement: survive on single digit hp
    // achievement kill x amount of bosses
    // some bosses should be weaker, some stronger, depending on how far the game has progressed? or: you can come back to the rooms with strong bosses later anyway


}
