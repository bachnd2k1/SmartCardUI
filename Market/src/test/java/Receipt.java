/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ZZ
 */
public class Receipt {
    private String name_cus, time, name_drink;
    private int id_mov, ticket, price, pops, drinks, point, total;

    public Receipt(String name_cus, String time, String name_drink, int id_mov, int ticket, int price, int pops, int drinks, int point, int total) {
        this.name_cus = name_cus;
        this.time = time;
        this.name_drink = name_drink;
        this.id_mov = id_mov;
        this.ticket = ticket;
        this.price = price;
        this.pops = pops;
        this.drinks = drinks;
        this.point = point;
        this.total = total;
    }

    public Receipt(){
        
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName_cus() {
        return name_cus;
    }

    public void setName_cus(String name_cus) {
        this.name_cus = name_cus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName_drink() {
        return name_drink;
    }

    public void setName_drink(String name_drink) {
        this.name_drink = name_drink;
    }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getPops() {
        return pops;
    }

    public void setPops(int pops) {
        this.pops = pops;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
