package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="shoppingItem")
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private int amount;

    public ShoppingItem() {
        this.name = "none";
        this.amount = 0;
    }

    public ShoppingItem(String name) {
        this.name = name;
        this.amount = 1;
    }

    public ShoppingItem(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShoppingItem [amount=" + amount + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShoppingItem other = (ShoppingItem) obj;
        if (amount != other.amount)
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
}
