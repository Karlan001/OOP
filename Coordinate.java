public class Coordinate {
    int x = 0;
    int y = 0;

    protected Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
