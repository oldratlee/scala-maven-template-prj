package com.oldratlee.scala.hello;

public class Company {
    private final String name;
    private final String address;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }
}
