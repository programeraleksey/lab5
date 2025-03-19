package org.example.models;

public enum Furnish {
    DESIGNER("designer"),
    NONE("none"),
    FINE("fine"),
    BAD("bad"),
    LITTLE("little");

    private String description;

    private Furnish(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    public Furnish fromDescription(String desc) {
        for (Furnish furnish: Furnish.values()) {
            if (furnish.description.equals(desc)) return furnish;
        }
        return null;
    }
}