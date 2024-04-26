/*
Krok 10.
Zdefiniuj klasę Resource. W klasie Resource zdefiniuj publiczny typ wyliczeniowy Type {Coal, Wood,
Fish}. Klasa Resource powinna posiadać dwa publiczne, ostateczne pola: punkt (Point) określający
rozmieszczenie pozycję zasobu na mapie oraz typ (Type) zasobu. Napisz konstruktor ustawiający te
pola.
 */

public class Resource {
    public enum Type { Coal, Wood, Fish }

    public final Point point;
    public final Type type;

    public Resource(Point point, Type type) {
        this.point = point;
        this.type = type;
    }
}

