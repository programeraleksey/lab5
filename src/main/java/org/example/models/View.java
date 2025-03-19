package org.example.models;

public enum View {
    STREET("street"),
    BAD("bad"),
    NORMAL("normal");

    private String description;

    private View(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }
}