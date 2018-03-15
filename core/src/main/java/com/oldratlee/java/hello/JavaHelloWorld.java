package com.oldratlee.java.hello;

import com.oldratlee.scala.hello.HelloService;

public class JavaHelloWorld implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        HelloService helloService = new JavaHelloWorld();
        System.out.println(helloService.hello("world"));
    }
}
