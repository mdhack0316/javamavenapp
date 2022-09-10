package com.mycompany.app;

/**
 * Hello From Jenkins Training!
 */
public class App
{

    private final String message = "Hello From Jenkins Training!";

    public App() {}

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
    }

    private final String getMessage() {
        return message;
    }

}
