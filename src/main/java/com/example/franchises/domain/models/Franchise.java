package com.example.franchises.domain.models;

public class Franchise {

    private Long id;
    private String name;

    public Franchise(Long id,String name) {
        this.name = name;
        this.id = id;
    }

    public Franchise() {
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
}
