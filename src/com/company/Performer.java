package com.company;

import java.io.Serializable;

public class Performer extends Person implements Serializable {
    private double experience;
    private String position;

    public Performer(String lastName, String firstName, String position, double experience) {
        super(lastName, firstName);
        this.experience = experience;
        this.position = position;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Прізвище: " + this.getFirstName() + ", Ім'я: " + this.getLastName() + ", Стаж: " + this.experience + ", Посада" + this.position;
    }
}
