package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Project extends State implements Serializable {
    private String name;
    private String lang;
    private String date;
    private double cost;
    private ArrayList<Performer> performers = new ArrayList<>();

    public Project(int rate, String description, String name, String lang, String date, double cost, Performer performer) {
        super(rate, description);
        this.name = name;
        this.lang = lang;
        this.date = date;
        this.cost = cost;
        this.performers.add(performer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }
    public void setPerformers(Performer performers) {
        this.performers.add(performers);
    }

    public void EditProject(int rate, String description, String name, String lang, String date, double cost) {
        setRate(rate);
        setDescription(description);
        this.name = name;
        this.lang = lang;
        this.date = date;
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "Назва: " + this.name + ", Мова програмування: " + this.lang + ", Дата: " + this.date + ", Ціна: " + this.cost;
    }
}
