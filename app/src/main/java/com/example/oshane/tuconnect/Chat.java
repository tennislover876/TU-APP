package com.example.oshane.tuconnect;

/*import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;



import android.view.LayoutInflater;
public class Chat extends AppCompatActivity {
    ArrayAdapter newArrayAdapter;
    String chatMessage;
    Button newButton;
    EditText newEditText;
    ArrayAdapter arrayAdapter;
    ListView newListView;
    LinearLayout bubble;

    String MainUser = "";
    ArrayList<String> newArray = new ArrayList<>();

    public void toSendChat(View view) {

        newEditText = findViewById(R.id.chatBoxID);
        chatMessage = newEditText.getText().toString();
        ParseObject object = new ParseObject("CHAT");

        object.put("sender", ParseUser.getCurrentUser().getUsername());
        object.put("recipient", MainUser);
        object.put("MESSAGE", chatMessage);
        newEditText.setText("");
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    newArray.add(chatMessage);
                    newArrayAdapter.notifyDataSetChanged();
                }

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        MainUser = intent.getStringExtra("username");
        Toast.makeText(getBaseContext(), MainUser, Toast.LENGTH_SHORT).show();


        setTitle("Chat with " + MainUser);


        newListView = findViewById(R.id.viewMessageID);
        newArrayAdapter = new ArrayAdapter(Chat.this, android.R.layout.simple_list_item_1, newArray);
        //newArrayAdapter = new bubbleAdapter();
        newListView.setAdapter(newArrayAdapter);

        ParseQuery<ParseObject> firstQuery = new ParseQuery<ParseObject>("CHAT");
        firstQuery.whereEqualTo("sender", ParseUser.getCurrentUser().getUsername());
        firstQuery.whereEqualTo("recipient", MainUser);

        ParseQuery<ParseObject> secondQuery = new ParseQuery<ParseObject>("CHAT");
        firstQuery.whereEqualTo("recipient", ParseUser.getCurrentUser().getUsername());
        firstQuery.whereEqualTo("sender", MainUser);

        List<ParseQuery<ParseObject>> bothQueries = new ArrayList<ParseQuery<ParseObject>>();
        bothQueries.add(firstQuery);
        bothQueries.add(secondQuery);
        ParseQuery<ParseObject> realQuery = ParseQuery.or(bothQueries);
        realQuery.orderByAscending("createdAt");


        realQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    newArray.clear();

                    for (ParseObject object : objects) {

                        String Chatted = object.getString("MESSAGE");

                        if (object.getString("sender").equals(ParseUser.getCurrentUser().getUsername()) && object.getString("recipient").equals(MainUser)) {
                            //  bubble = (LinearLayout) findViewById(R.id.bubble_layout);
                            //bubble.setBackgroundResource(R.drawable.bubble2);
                            Chatted = "you: " + Chatted;

                        } else if (object.getString("recipient").equals(ParseUser.getCurrentUser().getUsername()) && object.getString("sender").equals(MainUser)) {
                            //bubble = (LinearLayout) findViewById(R.id.bubble_layout);
                            //bubble.setBackgroundResource(R.drawable.bubble1);
                            Chatted = "> " + Chatted;
                        } else {
                            continue;
                        }

                        newArray.add(Chatted);

                    }


                    newArrayAdapter.notifyDataSetChanged();


                }
            }
        });


    }
}*/





import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;



import android.view.LayoutInflater;
public class Chat extends AppCompatActivity {
   MyAdapter newArrayAdapter;
    String chatMessage;
    Button newButton;
    EditText newEditText;
    ArrayAdapter arrayAdapter;

    ListView newListView;
    LinearLayout bubble;

    String MainUser = "";

    ArrayList<Item> newArray=new ArrayList<>();

    public void toSendChat(View view) {

        newEditText = findViewById(R.id.chatBoxID);
        chatMessage = newEditText.getText().toString();
        ParseObject object = new ParseObject("CHAT");

        object.put("sender", ParseUser.getCurrentUser().getUsername());
        object.put("recipient", MainUser);
        object.put("MESSAGE", chatMessage);
        newEditText.setText("");
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    newArray.add(new Item(chatMessage,true,""));
                    newArrayAdapter.notifyDataSetChanged();
                }

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        MainUser = intent.getStringExtra("username");
        TextView textView=(TextView) findViewById(R.id.textViewID);
        textView.setText("Chat with " + MainUser);



        newListView = findViewById(R.id.viewMessageID);
        newArrayAdapter = new MyAdapter(this, R.layout.chatbubble, newArray);

        newListView.setAdapter(newArrayAdapter);

        ParseQuery<ParseObject> firstQuery = new ParseQuery<ParseObject>("CHAT");
        firstQuery.whereEqualTo("sender", ParseUser.getCurrentUser().getUsername());
        firstQuery.whereEqualTo("recipient", MainUser);

        ParseQuery<ParseObject> secondQuery = new ParseQuery<ParseObject>("CHAT");
        firstQuery.whereEqualTo("recipient", ParseUser.getCurrentUser().getUsername());
        firstQuery.whereEqualTo("sender", MainUser);

        List<ParseQuery<ParseObject>> bothQueries = new ArrayList<ParseQuery<ParseObject>>();
        bothQueries.add(firstQuery);
        bothQueries.add(secondQuery);
        ParseQuery<ParseObject> realQuery = ParseQuery.or(bothQueries);
        realQuery.orderByAscending("createdAt");


        realQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    newArray.clear();

                    for (ParseObject object : objects) {

                        String Chatted = object.getString("MESSAGE");
                        boolean a;


                        if (object.getString("sender").equals(ParseUser.getCurrentUser().getUsername()) && object.getString("recipient").equals(MainUser)) {

                            a= true;

                        } else if (object.getString("recipient").equals(ParseUser.getCurrentUser().getUsername()) && object.getString("sender").equals(MainUser)) {

                            a= false;

                        } else {

                            continue;
                        }
                        newArray.add(new Item(Chatted,a,""));

                    }

                    newArrayAdapter.notifyDataSetChanged();

                }
            }
        });


    }

}










