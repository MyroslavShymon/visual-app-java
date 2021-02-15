package com.company;

import java.io.Serializable;

public class State implements Serializable {
    private int rate;
    private String description;

    public State(int rate, String description){
        this.rate = rate;
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Процент виконання: " + this.rate + ", Пояснення стану задачі на данний момент: " + this.description;
    }
}
