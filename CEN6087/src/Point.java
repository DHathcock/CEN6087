import java.util.concurrent.ThreadLocalRandom;

public class Point implements Comparable<Point>, Cloneable{
    // horizontal point
    public int X;
    // vertical point
    public int Y;

    Point(){
        X = -1;
        Y = -1;
    }

    Point(int a, int b){
        X = a;
        Y = b;
    }

//    Point(int minA , int maxA, int minB, int maxB) {
//        X = ThreadLocalRandom.current().nextInt(minA,maxA);
//        Y = ThreadLocalRandom.current().nextInt(minB,maxB);
//    }

    public void set(int x, int y) {
        X=x;
        Y=y;
    }

    public int compareTo(Point p) {
        return (X-p.X) - (Y-p.Y);
    }

    public Point clone(){
        return new Point(X,Y);
    }
}
