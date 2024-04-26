/*
Krok 4.
Dodaj do projektu bibliotekę JUnit,. Napisz trzy testy. W każdym stwórz wielokąt oraz punkt - tak aby
w kolejnych testach:
- punkt leżał w wielokącie,
- punkt leżał pod wielokątem,
- punkt leżał na prawo od wielokąta.
Uwaga! W przypadku tego oraz pozostałych kroków wymagających testowania, w razie
nieumiejętności wykorzystania biblioteki JUnit, część punktów można zdobyć pisząc metody klasy
Main, wykonujące działania, które mają zostać przetestowane.
Wyobraźmy sobie dwuwymiarową mapę, na której położenie jest opisane za pomocą współrzędnych
x i y, gdzie punkt (0, 0) znajduje się w lewej górnej krawędzi mapy. Mapa jest uproszczonym
modelem, nie uwzględniającym krzywizny Ziemi, który może być wykorzystany np. na potrzeby gry
komputerowej. Na mapie znajdują się lądy opisane za pomocą wielokątów.

 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class PolygonTest {
    @Test
    public void pointInsidePolygon() {
        // Tworzymy wielokąt
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(new Point(0, 0));
        pointsList.add(new Point(4, 0));
        pointsList.add(new Point(4, 4));
        pointsList.add(new Point(0, 4));
        Polygon polygon = new Polygon(pointsList);

        // Tworzymy punkt wewnątrz wielokąta
        Point insidePoint = new Point(2, 2);

        // Sprawdzamy, czy punkt znajduje się wewnątrz wielokąta
        assertTrue(polygon.inside(insidePoint));
    }

    @Test
    public void pointOutsidePolygon() {
        // Tworzymy wielokąt
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(new Point(0, 0));
        pointsList.add(new Point(4, 0));
        pointsList.add(new Point(4, 4));
        pointsList.add(new Point(0, 4));
        Polygon polygon = new Polygon(pointsList);

        // Tworzymy punkt na zewnątrz wielokąta
        Point outsidePoint = new Point(5, 5);

        // Sprawdzamy, czy punkt znajduje się na zewnątrz wielokąta
        assertFalse(polygon.inside(outsidePoint));
    }

    @Test
    public void pointOnEdgeOfPolygon() {
        // Tworzymy wielokąt
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(new Point(0, 0));
        pointsList.add(new Point(4, 0));
        pointsList.add(new Point(4, 4));
        pointsList.add(new Point(0, 4));
        Polygon polygon = new Polygon(pointsList);

        // Tworzymy punkt na krawędzi wielokąta
        Point onEdgePoint = new Point(2, 0);

        // Sprawdzamy, czy punkt znajduje się na krawędzi wielokąta
        assertFalse(polygon.inside(onEdgePoint));
    }
}
