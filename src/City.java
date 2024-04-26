/*
Krok 6.
Napisz klasę City dziedziczącą po Polygon. W klasie zdefiniuj publiczną ostateczną zmienną center -
punkt będący środkiem miasta oraz prywatną nazwę miasta. Napisz publiczny konstruktor, takie dwa
argumenty oraz liczbę zmiennoprzecinkową - długość ściany muru. Konstruktor powinien zapisać
w polu klasy środek miasta oraz nazwę, a w liście punktów odziedziczonej z klasy Polygon,
wierzchołki kwadratu stanowiącego mury.
Uwaga! Ten krok da się rozwiązać bez zmiany modyfikatora dostępu do listy wierzchołków wielokąta
na chroniony. Można dokonać takiej zmiany, ale takie rozwiązanie nie będzie w pełni punktowane.
Miasta mogą znajdować się na lądzie - nie na wodzie.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class City extends Polygon {
    public final Point center;
    private String cityName;

    public City(Point center, String cityName, double wallLength) {
        super(createCityVertices(center, wallLength));
        this.center = center;
        this.cityName = cityName;
    }

    private static List<Point> createCityVertices(Point center, double wallLength) {
        List<Point> vertices = new ArrayList<>();
        double halfWallLength = wallLength / 2.0;
        vertices.add(new Point(center.x - halfWallLength, center.y - halfWallLength));
        vertices.add(new Point(center.x + halfWallLength, center.y - halfWallLength));
        vertices.add(new Point(center.x + halfWallLength, center.y + halfWallLength));
        vertices.add(new Point(center.x - halfWallLength, center.y + halfWallLength));
        return vertices;
    }

    /*Krok 9.
    W klasie City dodaj prywatne pole logiczne port określające, czy miasto jest portowe. Miasto jest
    miastem portowym, jeżeli co najmniej jeden z wierzchołków kwadratu stanowiącego mury miasta
    znajduje się poza lądem.
    Pole to powinna ustawiać metoda znająca zarówno obiekt City, jak i obiekt Land, na którym istnieje
    lub do którego dodawane jest miasto. Samodzielnie wybierz odpowiednie położenie definicji
    i wywołania oraz symbol tej metody.
    Lądy i morza są pełne zasobów.
    */


    boolean port;

    public City(Point center, String cityName, double wallLength, Land land) {
        super(createCityVertices(center, wallLength));
        this.center = center;
        this.cityName = cityName;
        this.port = determineIfPort(land);
    }

     private boolean determineIfPort(Land land) {
        for (Point vertex : getPoints()) {
            if (!land.inside(vertex)) {
                return true;
            }
        }
        return false;
    }

    private Point[] getPoints() {
        return new Point[]{center, center, center};
    }

    /*
    Krok 11.
    Załóżmy bez sprawdzenia, że węgiel i drewno znajdują się na lądzie, a ryby w wodzie.
    W klasie City utwórz zbiór (Set) obiektów Resource.Type o nazwie resources i dostępie pakietowym.
    W tej samej klasie napisz metodę addResourcesInRange, która przyjmie listę obiektów Resource
    oraz liczbę zmiennoprzecinkową range i umieści w zbiorze typy tych zasobów, które znajdują się
    w odległości nie większej niż range od środka miasta. Ryby powinny być uwzględniane wyłącznie
    w miastach portowych.
     */

        Set<Resource.Type> resources = new HashSet<>();

        public void addResourcesInRange(List<Resource> allResources, double range) {
            for (Resource resource : allResources) {
                double distance = center.distanceTo(resource.point);
                if (distance <= range) {
                    if (resource.type == Resource.Type.Fish && !port) {
                        continue; // Ignore fish resources for non-port cities
                    }
                    resources.add(resource.type);
                }
            }
        }

}
