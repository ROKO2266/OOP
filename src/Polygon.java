/* Krok 2.
Zdefiniuj klasę Polygon, która będzie posiadała prywatną listę punktów. Lista punktów powinna być
ustawiana przez konstruktor. Wielokąt zbudowany jest z krawędzi łączących kolejne punkty w liście
oraz ostatni z pierwszym punktem z listy.
W dalszej części zadania, obiekty klasy Polygon będą skrótowo nazywane wielokątami.
 */

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Point> points;

    public Polygon(List<Point> points) {
        this.points = new ArrayList<>(points);
        // Dodajemy pierwszy punkt na koniec, aby mieć pełny wielokąt
        this.points.add(this.points.get(0));
    }

    /* Krok 3.
    W klasie Polygon zdefiniuj publiczną metodę inside(Point), która zwraca wartość logiczną określającą,
    czy dany argumentem metody punkt znajduje się w wielokącie, na rzecz którego wywoływana jest
    metoda. Zaimplementuj w niej algorytm podany pseudokodem:
    */

    public boolean inside(Point point) {
        int counter = 0;
        int n = points.size() - 1; // liczba krawędzi wielokąta

        for (int i = 0; i < n; i++) {
            Point pa = points.get(i);
            Point pb = points.get(i + 1);

            if (pa.y > pb.y) {
                Point temp = pa;
                pa = pb;
                pb = temp;
            }

            if (pa.y <= point.y && point.y < pb.y) {
                double d = pb.x - pa.x;
                double x;

                if (d == 0) {
                    x = pa.x;
                } else {
                    double a = (pb.y - pa.y) / d;
                    double b = pa.y - a * pa.x;
                    x = (point.y - b) / a;
                }

                if (x < point.x) {
                    counter++;
                }
            }
        }

        return counter % 2 != 0;
    }

}
