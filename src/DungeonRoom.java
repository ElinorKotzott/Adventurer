public class DungeonRoom {
    private boolean isVisited;
    private boolean isBossRoom;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public void setBossRoom(boolean bossRoom) {
        isBossRoom = bossRoom;
    }
}
