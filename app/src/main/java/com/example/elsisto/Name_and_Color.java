package com.example.elsisto;

public class Name_and_Color {
    private String name;
    private int color;

    Name_and_Color(String mName, int mColor){
        name=mName;
        color=mColor;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }
}
