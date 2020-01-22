package com.alex.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {

    private static final long serialVersionUID = 1642135873223469921L;

    private String name;

    public String getName() {

        return name;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : books) {
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
