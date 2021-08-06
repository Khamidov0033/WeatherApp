package com.example.weatherappusingretrofit;

public class Main {
    private String temp;
    private String seemsLike;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSeemsLike() {
        return seemsLike;
    }

    public void setSeemsLike(String seemsLike) {
        this.seemsLike = seemsLike;
    }

    public Main(String temp, String seemsLike) {
        this.temp = temp;
        this.seemsLike = seemsLike;
    }
}
