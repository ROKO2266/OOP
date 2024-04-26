import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello and welcome!");
        Point point = new Point(3.5, 2.0);
        System.out.println(point.x + " " + point.y);

        //Teraz możemy tworzyć obiekty klasy Polygon, przekazując listę punktów, np.:
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(new Point(0, 0));
        pointsList.add(new Point(1, 0));
        pointsList.add(new Point(1, 1));
        pointsList.add(new Point(0, 1));

        Polygon polygon = new Polygon(pointsList);
    }
}