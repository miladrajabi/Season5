package com.example.season5.objects;

public class spinnerCustomObject {

    int drawable;
    String name;

    public spinnerCustomObject(int drawable, String name) {
        this.drawable = drawable;
        this.name = name;
    }

    public spinnerCustomObject() {

    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
