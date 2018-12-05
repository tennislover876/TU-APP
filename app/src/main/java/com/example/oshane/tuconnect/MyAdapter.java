package com.example.oshane.tuconnect;

import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends ArrayAdapter<Item> {




    ArrayList<Item> chatMessageList=new ArrayList<>();



    public MyAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        chatMessageList=objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.chatbubble, null);

        TextView msg = (TextView) v.findViewById(R.id.message_text);
        TextView notUsed = (TextView) v.findViewById(R.id.messageNotUsed);
        msg.setText(chatMessageList.get(position).getMessage());
       //

        notUsed.setText(chatMessageList.get(position).getisnothing());
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = (LinearLayout) v.findViewById(R.id.bubble_layout_parent);


        // if message is mine then align to right
        if (chatMessageList.get(position).getisMine()) {
            layout.setBackgroundResource(R.drawable.bubble2);
            parent_layout.setGravity(Gravity.END);
        }
        // If not mine then align to left
        else {
            layout.setBackgroundResource(R.drawable.bubble1);
            parent_layout.setGravity(Gravity.START);
        }


        return v;
    }



}