package com.example.oshane.tuconnect;

import android.view.View;

import java.util.Random;

public class Item {

    String message;
    boolean isMine;
   String nothing;


    public Item(String message, boolean isMine, String nothing) {
        this.message = message;
        this.isMine = isMine;
        this.nothing = nothing;

    }


    public String getMessage() {
        return message;
    }




    public boolean getisMine() {
        return isMine;
    }




    public String getisnothing() {
        return nothing;
    }



}
