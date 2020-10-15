package com.company;

public enum Languages {
    UA("ukrainian"),
    EN("english");

    private final String title;

    Languages(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
