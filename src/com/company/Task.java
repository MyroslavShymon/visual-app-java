package com.company;

import java.io.Serializable;

public class Task implements Serializable, Comparable<Task> {
    private int number;
    private String title;
    private String setting;
    private String date;
    private double cost;
    private Performer performer;
    private Project project;

    public Task(int number, String title, String setting, String date, double cost, Performer performer, Project project) {
        this.number = number;
        this.title = title;
        this.setting = setting;
        this.date = date;
        this.cost = cost;
        this.performer = performer;
        this.project = project;
    }

    @Override
    public int compareTo(Task o) {
        return Double.compare(this.cost, o.cost);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
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

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public String toString() {
        return "Номер завдання: " + this.number + ", Заголовок: " + this.title + ", Постановка завдання: " + this.setting + ", Дата: " + this.date + ", Ціна: " + this.cost;
    }
}
