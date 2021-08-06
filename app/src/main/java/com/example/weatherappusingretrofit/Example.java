package com.example.weatherappusingretrofit;

import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Example(Main main) {
        this.main = main;
    }
}
