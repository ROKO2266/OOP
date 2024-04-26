/* Krok 5.
Napisz klasę Land dziedziczącą po klasie Polygon. Napisz w niej taki sam konstruktor jak w Polygon.
Na mapie znajdują się także miasta. Każde miasto otoczone jest murami w kształcie kwadratu,
o ścianach wychodzących na cztery strony świata (parami równoległe do osi układu współrzędnych).
Środek miasta leży na przecięciu przekątnych kwadratu. */

import java.util.List;

public class Land extends Polygon {
    public Land(List<Point> points) {
        super(points);
    }
}
