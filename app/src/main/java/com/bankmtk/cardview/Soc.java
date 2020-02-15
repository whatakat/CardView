package com.bankmtk.cardview;

public class Soc {
    private String description;
    private int picture;
    private boolean complete;
    public Soc(String description, int picture, boolean complete){
        this.description = description;
        this.picture  = picture;
        this.complete = complete;
    }
    public String getDescription(){
        return description;
    }
    public int getPicture(){
        return picture;
    }
    public boolean getComplete(){
        return complete;
    }
}
