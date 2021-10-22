package by.serzhant.webparser.entity;

import java.util.Objects;

public class SynthesizedGem extends Gem {
    private String creationDate;

    public SynthesizedGem(String name, int ID, String price, String preciousness, String origin, String color, double transparency, int facet, double weight, String creationDate) {
        super(name, ID, price, preciousness, origin, color, transparency, facet, weight);
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SynthesizedGem that = (SynthesizedGem) o;
        return Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creationDate);
    }

    @Override
    public String toString() {
        return super.toString() + " " + creationDate;
    }
}
