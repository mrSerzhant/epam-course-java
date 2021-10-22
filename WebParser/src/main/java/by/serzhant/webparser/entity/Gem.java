package by.serzhant.webparser.entity;

import java.util.Objects;

public abstract class Gem {
    private String name;
    private int ID;
    private String price;
    private String preciousness;
    private String origin;
    private String color;
    private double transparency;
    private int facet;
    private double weight;

    public Gem(String name, int ID, String price, String preciousness, String origin, String color, double transparency, int facet, double weight) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.preciousness = preciousness;
        this.origin = origin;
        this.color = color;
        this.transparency = transparency;
        this.facet = facet;
        this.weight = weight;
    }

    public String getMiningMethod() {
        return null;
    }

    public String getCreationDate() {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getPrice() {
        return price;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public String getColor() {
        return color;
    }

    public double getTransparency() {
        return transparency;
    }

    public int getFacet() {
        return facet;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gem gem = (Gem) o;
        return ID == gem.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", price='" + price + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", origin='" + origin + '\'' +
                ", color='" + color + '\'' +
                ", transparency=" + transparency +
                ", facet=" + facet +
                ", weight=" + weight +
                '}';
    }
}
