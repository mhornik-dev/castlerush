package mod.model.events;

public class Move {
    private int x;
    private int y;

    public Move() {
        this(0, 0);
    }

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

}
