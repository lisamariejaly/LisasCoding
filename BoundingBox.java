package geometry;

import java.util.List;
import com.jogamp.nativewindow.util.Point;

public class BoundingBox {
	
	private static Point minPoint;
    private static Point maxPoint;

    public BoundingBox(List<Point> manyPoints) {
        double minX = manyPoints.get(0).getX();
        double maxX = manyPoints.get(0).getX();
        double minY = manyPoints.get(0).getY();
        double maxY = manyPoints.get(0).getY();

        for (int i = 0; i < manyPoints.size(); i++) {
            Point test = manyPoints.get(i);
            test.getX();

            if (test.getX() < minX) {
                minX = test.getX();

            }

            if (test.getX() > maxX) {
                maxX = test.getX();
            }

            if (test.getY() < minY) {
                minY = test.getY();

            }

            if (test.getY() > maxY) {
                maxY = test.getY();

            }

            minPoint = new Point(minX, minY);
            maxPoint = new Point(maxX, maxY);

        }
    }

    public static double width() {

        double a = (maxPoint.getX() - minPoint.getX());
        return a;
    }

    public static double height() {
        System.out.println("minPoint = " + minPoint);
        System.out.println("maxPoint = " + maxPoint);
        double b = (maxPoint.getY() - minPoint.getY());
        return b;
    }

    public Point getMaxPoint() {
        return maxPoint;
    }

    public Point getMinPoint() {
        return minPoint;
    }
}


