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

    public int coordCalc(int x, int y, int x2, int y2){
        int calc = (int) Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y)));
        return calc;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
