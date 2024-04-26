/*
Krok 1.
Zdefiniuj rekord lub klasę Point posiadającą dwa publiczne, ostateczne pola - liczby
zmiennoprzecinkowe. Liczby te powinny być ustawiane za pomocą konstruktora.
W dalszej części zadania, obiekty klasy Point będą skrótowo nazywane punktami.
*/

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        return 0;
    }
}