package com.company;

public class Hero {
    private String name;
    private int hp;
    private int att;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public Hero(String name, int hp, int att) {
        this.name = name;
        this.hp = hp;
        this.att = att;
    }

    @Override
    public String toString() {
        return name + "\n    HP - " + hp + "\n    ATTACK - " + att;
    }
}
