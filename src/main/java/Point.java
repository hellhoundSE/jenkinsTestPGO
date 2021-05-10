public class Point {

    private int x;
    private int y;

    private Point() {
        this.x = 0;
        this.y = 0;
    }

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point createPoint() {
        return new Point();
    }

    public static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static Point translate(Point point, int x, int y) {
        return new Point(point.getX() + x, point.getY() + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
