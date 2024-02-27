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

    /**
     * Алгорить вычисления расстояния
     * @param x координата x текущиго объекта
     * @param y координата y текущего объекта
     * @param x2 координата x объекта для рассчета
     * @param y2 координата y объекта для рассчета
     * @return возвращаем результат по формуле AB = √(xb - xa)2 + (yb - ya)2
     */
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
    protected Coordinate getDifference(Coordinate target){
        Coordinate diff = new Coordinate(x - target.x, y - target.y);
        return diff;
    }

    public boolean equals(Coordinate frendly) {
        return x == frendly.x && y == frendly.y;

    }
}
