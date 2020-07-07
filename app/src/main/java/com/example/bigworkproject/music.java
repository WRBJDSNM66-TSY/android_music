package com.example.bigworkproject;

public class music {
    private String Mname;
    private String Mauthor;

    public music() {
    }

    public music(String Mname, String Mauthor) {
        this.Mname = Mname;
        this.Mauthor = Mauthor;
    }

    public String getName() {
        return Mname;
    }

    public String getAuthor() {
        return Mauthor;
    }

    public void setName(String Mname) {
        this.Mname = Mname;
    }

    public void setAuthor(String Mauthor) {
        this.Mauthor = Mauthor;
    }
}
