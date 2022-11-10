package com.company;

public class Boss{
    private int number;
    private int hp;
    private int att;
    boolean isAlive = true;

    @Override
    public String toString() {
        return number + ". Boss" + "\n    HP - " + hp + "\n    ATTACK - " + att;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Boss(int number, int hp, int att) {
        this.number = number;
        this.hp = hp;
        this.att = att;
    }
}
