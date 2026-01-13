package com.example.egzaminlistask;

public class Todo {
    private String nazwa;
    private boolean CzyWykonane;
    private byte piorytet;

    public Todo(String nazwa, byte piorytet) {
        this.nazwa = nazwa;
        this.piorytet = piorytet;
        CzyWykonane = false;
    }

    public boolean isCzyWykonane() {
        return CzyWykonane;
    }

    public void setCzyWykonane(boolean czyWykonane) {
        this.CzyWykonane = czyWykonane;
    }

    public byte getPiorytet() {
        return piorytet;
    }

    public void setPiorytet(byte piorytet) {
        this.piorytet = piorytet;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "piorytet=" + piorytet +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
