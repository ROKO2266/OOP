/*
Krok 12.
Napisz klasę CityTest zawierającą sparametryzowany test zawierający:
- poprawne dodanie węgla,
- nieudaną próbę dodania drewna spoza zasięgu miasta,
- poprawne dodanie ryb do miasta portowego,
- nieudaną próbę dodania ryb do miasta nieportowego.
Test będzie wymagał definicji miasta śródlądowego i morskiego, co można wykonać na wiele
sposobów, np. przez ustawienie ich jako pola klasy.
Test powinien przyjmować argumenty: miasto, zasób, oczekiwana wartość logiczna.
Sposób parametryzacji testu jest dowolny. Test, przy użyciu pakietowego dostępu do pola
City.resources powinien sprawdzać, czy testowany zasób został dodany do zbioru.
Dany jest plik map.svg zawierający przykładową mapę. Mapa zawiera niebieski prostokąt
reprezentujący wodę, który można pominąć w dalszych rozważaniach oraz za pomocą znaczników:
- polygon o kolorze zielonym - ląd,
- rect o kolorze czerwonym - miasto,
- circle o kolorze czarnym, brązowym, jasnoniebieskim - zasoby, odpowiednio węgiel, drewno,
ryby.
- text - nazwy miast.
Symbole zasobów nie będą rozważane w dalszej części zadania
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {
    private final double RANGE = 10.0;
    private final Land inlandLand = new Land(new ArrayList<>());
    private final Land portLand = new Land(new ArrayList<>());

    @Test
    public void testCoalAddition() {
        City inlandCity = new City(new Point(0, 0), "Inland City", 5.0, inlandLand);
        Resource coalResource = new Resource(new Point(1, 1), Resource.Type.Coal);
        inlandCity.addResourcesInRange(List.of(coalResource), RANGE);
        assertTrue(inlandCity.resources.contains(Resource.Type.Coal));
    }

    @Test
    public void testWoodAdditionOutOfRange() {
        City inlandCity = new City(new Point(0, 0), "Inland City", 5.0, inlandLand);
        Resource woodResource = new Resource(new Point(15, 15), Resource.Type.Wood);
        inlandCity.addResourcesInRange(List.of(woodResource), RANGE);
        assertFalse(inlandCity.resources.contains(Resource.Type.Wood));
    }

    @Test
    public void testFishAdditionInPortCity() {
        City portCity = new City(new Point(10, 10), "Port City", 5.0, portLand);
        portCity.port = true;
        Resource fishResource = new Resource(new Point(10, 12), Resource.Type.Fish);
        portCity.addResourcesInRange(List.of(fishResource), RANGE);
        assertTrue(portCity.resources.contains(Resource.Type.Fish));
    }

    @Test
    public void testFishAdditionInInlandCity() {
        City inlandCity = new City(new Point(0, 0), "Inland City", 5.0, inlandLand);
        Resource fishResource = new Resource(new Point(1, 1), Resource.Type.Fish);
        inlandCity.addResourcesInRange(List.of(fishResource), RANGE);
        assertFalse(inlandCity.resources.contains(Resource.Type.Fish));
    }
}
