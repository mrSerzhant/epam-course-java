package by.serzhant.webparser.entity;

import java.util.Objects;

public class NaturalGem extends Gem {
    private String miningMethod;

    public NaturalGem(String name, int ID, String price, String preciousness, String origin, String color, double transparency, int facet, double weight, String miningMethod) {
        super(name, ID, price, preciousness, origin, color, transparency, facet, weight);
        this.miningMethod = miningMethod;
    }

    public String getMiningMethod() {
        return miningMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NaturalGem that = (NaturalGem) o;
        return Objects.equals(miningMethod, that.miningMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), miningMethod);
    }

    @Override
    public String toString() {
        return super.toString() + " "  + miningMethod;
    }
}
