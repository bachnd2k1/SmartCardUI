/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.market;

import java.sql.Blob;

/**
 *
 * @author ZZ
 */
public class Movies {
    public String name;
    public int seat;
    public String date;
    public int room;
    public int price;
    public Blob image;

    public Movies(String name, int seat, String date, int room, int price, Blob image) {
        this.name = name;
        this.seat = seat;
        this.date = date;
        this.room = room;
        this.price = price;
        this.image = image;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
