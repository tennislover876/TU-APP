package com.example.oshane.tuconnect;

/**
 * Created by TUSKEGEE on 11/14/2017.
 */

public class ChatMessage {

    public String body, sender, receiver, senderName;
    public boolean isMine;// Did I send the message.
    public String nothing;

    public ChatMessage(String messageString, boolean isMINE, String nothing) {
        body = messageString;
        isMine = isMINE;
        nothing=nothing;


    }


}