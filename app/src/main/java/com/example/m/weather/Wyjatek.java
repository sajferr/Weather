package com.example.m.weather;

/**
 * Created by m on 2016-07-22.
 */
public class Wyjatek {

    private Exception exception;

    public Wyjatek(String jest) {
    }

    public Exception getException() {
        return exception;
    }



    public String getCoJest() {
        return coJest;
    }

    String coJest;
    Wyjatek(String coJest,Exception exception){

        this.coJest=coJest;
        this.exception=exception;
    }















}
