package com.machine.vending.model;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    //add brand
    private String brand;
    private int quantity;


    public Machine() {}
//add brand in both
    public Machine(String name, double price, int quantity, String brand) {
        this.name = name;
        this.price = price;
    //add brand here
        this.brand = brand;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //New Brand added
    public String getBrand() { return brand; }

    public void setBrand (String brand) {this.brand = brand;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Vending_Machine_Item{" +
                "id" + id +
                ", name'" + name + '\'' +
                ", price" + price +
                ", brand" + brand +
                ", quantity" + quantity +
                '}';
    }
}

